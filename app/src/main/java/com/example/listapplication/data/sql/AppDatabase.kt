package com.example.listapplication.data.sql

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listapplication.data.text.sql.TextDao
import com.example.listapplication.data.text.sql.entity.TextEntity

@Database(entities = [TextEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao
}