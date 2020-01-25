package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class ProductRankings(
  @SerializedName("ranking") val ranking: String,
  @SerializedName("products") val products: List<ProductViewCount>
)