package com.kailashdabhi.headytest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kailashdabhi.headytest.data.ProductRepository

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    ProductRepository.products().observe(this, Observer {
      Log.e("ob", it.toString())
    })
  }
}
