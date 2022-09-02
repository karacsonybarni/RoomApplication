package com.example.listapplication.data.text.sql

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.listapplication.data.text.sql.entity.TextEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TextDao {

    @Query("SELECT * FROM text")
    fun getAll(): Flow<List<TextEntity>>

    @Insert
    fun insert(textEntities: List<TextEntity>)

    @Query("DELETE FROM text")
    fun clearTexts()
}