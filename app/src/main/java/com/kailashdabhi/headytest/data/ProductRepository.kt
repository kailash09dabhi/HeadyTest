package com.kailashdabhi.headytest.data

import androidx.lifecycle.liveData
import com.kailashdabhi.headytest.ServiceLocator
import com.kailashdabhi.headytest.base.Resource
import com.kailashdabhi.headytest.data.model.Product

/**
 * @author kailash09dabhi@gmail.com
 * @date 21, Jan 2020 (17:42)
 */
object ProductRepository {
  fun products() = liveData {
    emit(Resource.loading(null))
    try {
      val data = ServiceLocator.apiService().products().body()
      val productList: ArrayList<Product> = arrayListOf()
      data?.categories
        ?.flatMap { categories -> categories.products }
        ?.forEach { productList.add(it) }
      emit(Resource.success(productList))
    } catch (e: Exception) {
      emit(Resource.error(e.message ?: "", null))
    }
  }
}