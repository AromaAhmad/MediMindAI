package com.aroma.medimindai.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aroma.medimindai.data.ChatMessage
import com.aroma.medimindai.data.local.AppDatabase
import com.aroma.medimindai.data.repository.HealthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val chatDao = AppDatabase.getDatabase(application).chatDao()
    private val repository = HealthRepository(chatDao)

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    init {
        viewModelScope.launch {
            val saved = repository.getAllMessages()
            _messages.value = saved.map { entity ->
                ChatMessage(message = entity.message, isUser = entity.isUser)
            }
        }
    }
}