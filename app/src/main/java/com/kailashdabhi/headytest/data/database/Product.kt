package com.kailashdabhi.headytest.data.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kailashdabhi.headytest.data.model.Tax
import com.kailashdabhi.headytest.data.model.Variants
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Product")
data class Product(
  @PrimaryKey
  @ColumnInfo(name = "id")
  val id: Int,
  @ColumnInfo(name = "name")
  val name: String,
  @ColumnInfo(name = "date_added")
  val dateAdded: String,
  @ColumnInfo(name = "variants")
  val variants: List<Variants>,
  @ColumnInfo(name = "tax")
  val tax: Tax,
  @ColumnInfo(name = "category")
  val category: String = "",
  @ColumnInfo(name = "view_count")
  val viewCount: Long = 0,
  @ColumnInfo(name = "order_count")
  val orderCount: Long = 0,
  @ColumnInfo(name = "share_count")
  val shareCount: Long = 0
) : Parcelable
