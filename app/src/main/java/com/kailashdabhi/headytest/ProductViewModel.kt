package com.kailashdabhi.headytest

import androidx.lifecycle.ViewModel
import com.kailashdabhi.headytest.data.ProductRepository

/**
 * @author kailash09dabhi@gmail.com
 * @date 22, Jan 2020 (16:29)
 */
class ProductViewModel : ViewModel() {
  fun products() = ProductRepository.products()
}