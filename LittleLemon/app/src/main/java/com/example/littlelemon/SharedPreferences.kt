package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()

        editor.putString(key, value)
        editor.apply()
    }
    fun deleteData(key: String){
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
}
