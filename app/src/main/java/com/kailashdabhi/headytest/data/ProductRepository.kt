package com.kailashdabhi.headytest.data

import androidx.lifecycle.liveData
import com.kailashdabhi.headytest.ServiceLocator
import com.kailashdabhi.headytest.base.Resource
import com.kailashdabhi.headytest.data.database.Product
import com.kailashdabhi.headytest.data.model.toProduct

/**
 * @author kailash09dabhi@gmail.com
 * @date 21, Jan 2020 (17:42)
 */
object ProductRepository {
  fun products() = liveData {
    emit(Resource.loading(null))
    try {
      val data = ServiceLocator.apiService().products().body()
      val productMap = hashMapOf<Int, Product>()
      data?.categories
        ?.flatMap { categories ->
          categories.products.map { productResponse ->
            productResponse.toProduct().copy(category = categories.name)
          }
        }
        ?.forEach { productMap.put(it.id, it) }
      data?.rankings?.forEach { ranking ->
        ranking.products.forEach { pr ->
          if (productMap.containsKey(pr.id)) {
            productMap[pr.id]?.copy(
              viewCount = pr.viewCount,
              orderCount = pr.orderCount,
              shareCount = pr.shareCount
            )?.let { productMap.put(pr.id, it) }
          }
        }
      }
      productMap.values.sortedBy { it.id }
      emit(Resource.success(productMap.values.toList()))
    } catch (e: Exception) {
      emit(Resource.error(e.message ?: "", null))
    }
  }
}