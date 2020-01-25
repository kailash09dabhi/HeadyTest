package com.kailashdabhi.headytest.data

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.kailashdabhi.headytest.ServiceLocator
import com.kailashdabhi.headytest.base.Resource
import com.kailashdabhi.headytest.data.database.Product
import com.kailashdabhi.headytest.data.model.toProduct
import kotlinx.coroutines.Dispatchers

/**
 * @author kailash09dabhi@gmail.com
 * @date 21, Jan 2020 (17:42)
 */
object ProductRepository {
  fun products() = liveData<Resource<List<Product>>>(Dispatchers.IO) {
    val productDao = ServiceLocator.database().productDao()
    val disposable = emitSource(productDao.productList().map { Resource.loading(it) })
    try {
      val data = ServiceLocator.apiService().products().body()
      val productMap = hashMapOf<Int, Product>()
      data?.categories
        ?.flatMap { categories ->
          categories.products.map { productResponse ->
            productResponse.toProduct().copy(category = categories.name)
          }
        }
        ?.forEach { productMap[it.id] = it }
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
      // Stop the previous emission to avoid dispatching the updated products
      // as `loading`.
      disposable.dispose()
      // Update the database.
      productDao.insertProducts(productMap.values.toList())

      // Re-establish the emission with success type.
      emitSource(productDao.productList().map { Resource.success(it) })
    } catch (exception: Exception) {
      // Any call to `emit` disposes the previous one automatically so we don't
      // need to dispose it here as we didn't get an updated value.
      emitSource(
        productDao.productList().map {
          Resource.error(exception.message?:"", it)
        }
      )
    }
  }
}