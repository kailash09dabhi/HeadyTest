package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class ProductOrderCount(
  @SerializedName("id") val id: Int,
  @SerializedName("order_count") val view_count: Int
)