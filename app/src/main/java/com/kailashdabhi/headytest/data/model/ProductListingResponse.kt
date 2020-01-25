package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class ProductListingResponse(
  @SerializedName("categories") val categories: List<Categories>,
  @SerializedName("rankings") val rankings: List<ProductRankings>
)