package com.example.listapplication.data.text

import android.content.Context
import com.example.listapplication.data.sql.DatabaseProvider

object TextsRepositoryProvider {

    private var localRepositoryInstance: TextsRepository? = null

    fun getLocal(applicationContext: Context): TextsRepository {
        var instance = localRepositoryInstance
        if (instance == null) {
            val database = DatabaseProvider.get(applicationContext)
            val textDao = database.textDao()
            instance = TextsRepository(TextsLocalDataSource(textDao))
            instance.fillDb()
            localRepositoryInstance = instance
        }
        return instance
    }
}