package com.aroma.medimindai.data.repository

import com.google.ai.client.generativeai.GenerativeModel
import com.aroma.medimindai.data.local.ChatDao
import com.aroma.medimindai.data.local.ChatEntity
class HealthRepository(private val chatDao: ChatDao) {




    private val model = GenerativeModel(
        modelName = "gemini-flash-latest",
        apiKey = com.aroma.medimindai.BuildConfig.GEMINI_API_KEY
    )

    suspend fun getSymptomAnalysis(userMessage: String): String {
        return try {
            val prompt = """
                You are MediMind AI, a friendly and knowledgeable health assistant.
                Provide clear, concise, and helpful responses.
                Always remind users to consult a doctor for serious concerns.
                
                User: $userMessage
            """.trimIndent()

            val response = model.generateContent(prompt)
            response.text ?: "Sorry, I couldn't process your request."
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
    suspend fun getAllMessages(): List<ChatEntity> {
        return chatDao.getAllMessages()
    }
    suspend fun saveMessage(message: String, isUser: Boolean) {
        chatDao.insertMessage(ChatEntity(message = message, isUser = isUser))
    }
}