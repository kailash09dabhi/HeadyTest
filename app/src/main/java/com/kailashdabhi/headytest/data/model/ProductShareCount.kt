package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class ProductShareCount(
  @SerializedName("id") val id: Int,
  @SerializedName("shares") val view_count: Int
)