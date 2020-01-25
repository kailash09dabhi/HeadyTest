package com.kailashdabhi.headytest

import com.kailashdabhi.headytest.data.api.ApiService
import com.kailashdabhi.headytest.data.database.ProductDatabase

/**
 * @author Kailash Dabhi
 * @email kailash09dabhi@gmail.com
 * @date 18/02/2019
 */
object ServiceLocator {
  private lateinit var apiService: ApiService
  private lateinit var database: ProductDatabase
  fun apiService(): ApiService {
    return apiService
  }

  fun apiService(apiService: ApiService) {
    ServiceLocator.apiService = apiService
  }

  fun database(): ProductDatabase {
    return database
  }

  fun database(productDatabase: ProductDatabase) {
    database = productDatabase
  }
}