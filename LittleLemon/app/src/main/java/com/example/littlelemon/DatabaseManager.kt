package com.example.littlelemon

import android.content.Context
import androidx.room.Room

class DatabaseManager {

    fun getDB(context: Context): MenuItemDao {

        val database by lazy {
            Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
        }
        return database.menuItemDao()
    }


}