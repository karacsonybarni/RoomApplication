package com.example.listapplication.data.text

import com.example.listapplication.data.text.model.TextModel
import com.example.listapplication.data.text.model.TextsModel
import com.example.listapplication.data.text.sql.TextDao
import com.example.listapplication.data.text.sql.entity.TextEntity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TextsLocalDataSource(
    private val textDao: TextDao,
    private val coroutineScope: CoroutineScope = GlobalScope,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TextsDataSource {

    private val mockEntities = listOf(
        TextEntity(text = "Hello"),
        TextEntity(text = "World")
    )

    override val textsModelFlow: Flow<TextsModel> =
        textDao.getAll().map { textEntityList -> toTextsModel(textEntityList) }

    private fun toTextsModel(textEntityList: List<TextEntity>): TextsModel {
        val textModelArray = textEntityList
            .map { textEntity -> toTextModel(textEntity) }
            .toTypedArray()
        return TextsModel(textModelArray)
    }

    private fun toTextModel(textEntity: TextEntity) = TextModel(textEntity.text)

    override fun fillDb() {
        coroutineScope.launch(coroutineDispatcher) {
            textDao.clearTexts()
            textDao.insert(mockEntities)
        }
    }
}