package com.example.listapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.listapplication.data.sql.DatabaseProvider
import com.example.listapplication.data.text.TextRepository
import com.example.listapplication.data.text.TextsLocalDataSource
import com.example.listapplication.data.text.model.TextsModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainViewModel(textRepository: TextRepository) : ViewModel() {

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val database = DatabaseProvider.get(application.applicationContext)
                val textDao = database.textDao()
                val textsRepository = TextRepository(TextsLocalDataSource(textDao))
                textsRepository.fillDb()
                return MainViewModel(textsRepository) as T
            }
        }
    }

    val texts = textRepository.textsModelFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        TextsModel(emptyArray())
    )
}