package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author kailash09dabhi@gmail.com
 * @date 25, Jan 2020 (11:50)
 */
data class Product(
  @SerializedName("id") val id: Int,
  @SerializedName("name") val name: String,
  @SerializedName("date_added") val dateAdded: String,
  @SerializedName("variants") val variants: List<Variants>,
  @SerializedName("tax") val tax: Tax
)
