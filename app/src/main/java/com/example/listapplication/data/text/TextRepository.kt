package com.example.listapplication.data.text

class TextRepository(private val dataSource: TextsDataSource) {

    val textsModelFlow = dataSource.textsModelFlow

    fun fillDb() {
        dataSource.fillDb()
    }
}