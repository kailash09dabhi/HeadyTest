package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class Variants(

  @SerializedName("id") val id: Int,
  @SerializedName("color") val color: String,
  @SerializedName("size") val size: Int,
  @SerializedName("price") val price: Int
)