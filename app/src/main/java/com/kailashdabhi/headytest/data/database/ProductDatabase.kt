package com.kailashdabhi.headytest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
  entities = [Product::class],
  exportSchema = false,
  version = 1
)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {

  companion object {
    private lateinit var instance: ProductDatabase
    fun from(context: Context): ProductDatabase {
      if (!::instance.isInitialized) {
        instance = Room.databaseBuilder(
          context.applicationContext,
          ProductDatabase::class.java,
          "product_database"
        )
          .fallbackToDestructiveMigration()
          .build()
      }
      return instance
    }
  }

  abstract fun productDao(): ProductDao
}