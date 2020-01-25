package com.kailashdabhi.headytest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
  entities = [Product::class],
  exportSchema = false,
  version = 1
)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {
  abstract fun productDao(): ProductDao
}