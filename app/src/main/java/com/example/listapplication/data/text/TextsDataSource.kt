package com.example.listapplication.data.text

import com.example.listapplication.data.text.model.TextsModel
import kotlinx.coroutines.flow.Flow

interface TextsDataSource {

    val textsModelFlow: Flow<TextsModel>

    fun fillDb()
}