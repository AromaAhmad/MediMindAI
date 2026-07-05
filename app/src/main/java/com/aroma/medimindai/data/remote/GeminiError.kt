package com.aroma.medimindai.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class GeminiError(
    val code: Int,
    val message: String,
    val status: String,
    val details: List<String>? = null
)