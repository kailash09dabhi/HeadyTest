package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class ProductRatingInfo(
  @SerializedName("id") val id: Int,
  @SerializedName("view_count") val viewCount: Long,
  @SerializedName("order_count") val orderCount: Long,
  @SerializedName("shares") val shareCount: Long
)