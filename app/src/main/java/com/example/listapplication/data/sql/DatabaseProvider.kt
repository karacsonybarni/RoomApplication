package com.example.listapplication.data.sql

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var db: AppDatabase? = null

    fun get(applicationContext: Context): AppDatabase {
        var localInstance = db
        if (localInstance == null) {
            localInstance = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()
        }
        db = localInstance
        return localInstance
    }
}