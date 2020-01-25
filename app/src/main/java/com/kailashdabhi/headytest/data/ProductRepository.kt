package com.kailashdabhi.headytest.data

import androidx.lifecycle.liveData
import com.kailashdabhi.headytest.ServiceLocator
import com.kailashdabhi.headytest.base.Resource

/**
 * @author kailash09dabhi@gmail.com
 * @date 21, Jan 2020 (17:42)
 */
object ProductRepository {
  fun products() = liveData {
    emit(Resource.loading(null))
    try {
      emit(Resource.success(ServiceLocator.apiService().products()))
    } catch (e: Exception) {
      emit(Resource.error(e.message ?: "", null))
    }
  }
}