package com.kailashdabhi.headytest.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kailashdabhi.headytest.data.model.Tax
import com.kailashdabhi.headytest.data.model.Variants

/**
 * @author Kailash Dabhi
 * @email kailash09dabhi@gmail.com
 * @date 16/01/2019
 */
class Converters {
  @TypeConverter
  fun stringToListOfVariants(json: String?): List<Variants>? {
    return if (json != null) {
      Gson().fromJson<List<Variants>>(
        json,
        object : TypeToken<List<String?>?>() {}.type
      )
    } else null
  }

  @TypeConverter
  fun listOfVariantsToString(`object`: List<Tax?>?): String {
    return if (`object` != null) {
      Gson().toJson(`object`)
    } else ""
  }

  @TypeConverter
  fun stringToTax(json: String?): Tax? {
    return if (json != null) {
      Gson().fromJson(json, Tax::class.java)
    } else null
  }

  @TypeConverter
  fun taxToString(`object`: Tax): String {
    return if (`object` != null) {
      Gson().toJson(`object`)
    } else ""
  }
}