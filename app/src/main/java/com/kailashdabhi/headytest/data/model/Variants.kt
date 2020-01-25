package com.kailashdabhi.headytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variants(

  @SerializedName("id") val id: Int,
  @SerializedName("color") val color: String,
  @SerializedName("size") val size: Int,
  @SerializedName("price") val price: Int
) : Parcelable