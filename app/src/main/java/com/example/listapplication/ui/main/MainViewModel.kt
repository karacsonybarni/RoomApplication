package com.example.listapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.listapplication.data.text.TextsRepository
import com.example.listapplication.data.text.TextsRepositoryProvider
import com.example.listapplication.data.text.model.TextsModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainViewModel(textsRepository: TextsRepository) : ViewModel() {

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val textsRepository = TextsRepositoryProvider.getLocal(application.applicationContext)
                return MainViewModel(textsRepository) as T
            }
        }
    }

    val texts = textsRepository.textsModelFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        TextsModel(emptyArray())
    )
}