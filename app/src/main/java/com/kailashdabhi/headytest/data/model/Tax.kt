package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

data class Tax(

  @SerializedName("name") val name: String,
  @SerializedName("value") val value: Double
)