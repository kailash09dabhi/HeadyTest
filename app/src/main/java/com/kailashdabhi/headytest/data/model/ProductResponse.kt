package com.kailashdabhi.headytest.data.model

import com.google.gson.annotations.SerializedName
import com.kailashdabhi.headytest.data.database.Product

/**
 * @author kailash09dabhi@gmail.com
 * @date 25, Jan 2020 (11:50)
 */
data class ProductResponse(
  @SerializedName("id") val id: Int,
  @SerializedName("name") val name: String,
  @SerializedName("date_added") val dateAdded: String,
  @SerializedName("variants") val variants: List<Variants>,
  @SerializedName("tax") val tax: Tax
)

fun ProductResponse.toProduct(): Product =
  Product(id = id, name = name, tax = tax, variants = variants, dateAdded = dateAdded)
