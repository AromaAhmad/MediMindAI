package com.aroma.medimindai.ui.chat

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aroma.medimindai.data.ChatMessage
import com.aroma.medimindai.data.local.AppDatabase
import com.aroma.medimindai.data.repository.HealthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val chatDao = AppDatabase.getDatabase(application).chatDao()
    private val repository = HealthRepository(chatDao)

    init {
        viewModelScope.launch {
            val saved = repository.getAllMessages()
            _messages.value = saved.map { entity ->
                ChatMessage(message = entity.message, isUser = entity.isUser)
            }
        }
    }

    private var isRequestInProgress = false
    private var lastRequestTime = 0L

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun sendMessage(userMessage: String) {
        val now = System.currentTimeMillis()
        if (isRequestInProgress) return
        if (now - lastRequestTime < 2000) return

        viewModelScope.launch {
            try {
                isRequestInProgress = true
                lastRequestTime = now

                _messages.value = _messages.value + ChatMessage(userMessage, true)
                _isLoading.value = true

                repository.saveMessage(userMessage, true)

                val response = callWithRetry {
                    repository.getSymptomAnalysis(userMessage)
                }

                _messages.value = _messages.value + ChatMessage(response, false)
                repository.saveMessage(response, false)

            } catch (e: HttpException) {
                Log.e("GEMINI", "HTTP Error ${e.code()}: ${e.message}")
                val errorMsg = when (e.code()) {
                    429 -> "Too many requests. Please wait a moment and try again."
                    500, 503 -> "Gemini service is currently unavailable. Try again shortly."
                    else -> "Something went wrong. Please try again."
                }
                _messages.value = _messages.value + ChatMessage(errorMsg, false)

            } catch (e: Exception) {
                Log.e("GEMINI", "Error: ${e.message}")
                _messages.value = _messages.value + ChatMessage(
                    "Unexpected error occurred. Please try again.", false
                )
            } finally {
                _isLoading.value = false
                isRequestInProgress = false
            }
        }
    }

    private suspend fun <T> callWithRetry(
        maxRetries: Int = 3,
        block: suspend () -> T
    ): T {
        repeat(maxRetries) { attempt ->
            try {
                return block()
            } catch (e: HttpException) {
                if (e.code() == 429 && attempt < maxRetries - 1) {
                    val delayMs = 5000L * (attempt + 1)
                    Log.w("GEMINI", "Rate limited. Retrying in ${delayMs}ms (attempt ${attempt + 1})")
                    delay(delayMs)
                } else throw e
            }
        }
        throw Exception("Max retries reached")
    }
}