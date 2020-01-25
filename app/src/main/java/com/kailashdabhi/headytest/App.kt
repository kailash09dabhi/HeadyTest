package com.kailashdabhi.headytest

import android.app.Application
import com.kailashdabhi.headytest.data.api.RestClient

/**
 * @author kailash09dabhi@gmail.com
 * @date 23, Jan 2020 (12:35)
 */
class App : Application() {
  override fun onCreate() {
    super.onCreate()
    ServiceLocator.apiService(RestClient().apiService())
  }
}