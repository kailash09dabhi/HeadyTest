package com.kailashdabhi.headytest.data.api

import com.kailashdabhi.headytest.data.model.ProductListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
  companion object {
    const val API_ENDPOINT = "https://stark-spire-93433.herokuapp.com/"
  }

  @GET("json")
  suspend fun products(): Response<ProductListingResponse>
}