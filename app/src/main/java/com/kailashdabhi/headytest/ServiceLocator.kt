package com.kailashdabhi.headytest

import com.kailashdabhi.headytest.data.api.ApiService

/**
 * @author Kailash Dabhi
 * @email kailash09dabhi@gmail.com
 * @date 18/02/2019
 */
object ServiceLocator {
  private lateinit var apiService: ApiService
  fun apiService(): ApiService {
    return apiService
  }

  fun apiService(apiService: ApiService) {
    ServiceLocator.apiService = apiService
  }
}