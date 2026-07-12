package com.aroma.medimindai.data

data class ChatMessage(
    val message: String,
    val isUser: Boolean,
    val imagePath: String? = null
)