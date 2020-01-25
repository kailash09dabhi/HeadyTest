package com.kailashdabhi.headytest.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kailashdabhi.headytest.data.database.Product

@Dao
interface ProductDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertProduct(listReport: List<Product>)

  @Query("SELECT * FROM Product")
  fun productList(): LiveData<List<Product>>

}