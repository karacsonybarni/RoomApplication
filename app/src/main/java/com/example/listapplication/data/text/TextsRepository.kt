package com.example.listapplication.data.text

class TextsRepository(private val dataSource: TextsDataSource) {

    val textsModelFlow = dataSource.textsModelFlow

    fun fillDb() {
        dataSource.fillDb()
    }
}