package com.kailashdabhi.headytest.data.api

import com.kailashdabhi.headytest.BuildConfig
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.MINUTES

class RestClient @JvmOverloads constructor(url: String? = ApiService.API_ENDPOINT) {
  private val retrofit: Retrofit
  fun apiService(): ApiService {
    return retrofit.create(ApiService::class.java)
  }

  companion object {
    private val LOG_ENABLED = BuildConfig.DEBUG
  }

  init {
    val httpClientBuilder = Builder()
      .connectTimeout(1, MINUTES)
      .readTimeout(1, MINUTES)
      .writeTimeout(1, MINUTES)
    if (LOG_ENABLED) {
      val logging = HttpLoggingInterceptor()
      logging.level = BODY
      httpClientBuilder.addInterceptor(logging)
    }
    retrofit = Retrofit.Builder()
      .baseUrl(url)
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClientBuilder.build())
      .build()
  }
}