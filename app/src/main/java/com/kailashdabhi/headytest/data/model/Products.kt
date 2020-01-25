package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class Products(

  @SerializedName("id") val id: Int,
  @SerializedName("view_count") val view_count: Int
)