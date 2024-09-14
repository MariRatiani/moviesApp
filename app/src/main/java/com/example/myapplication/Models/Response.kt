package com.example.myapplication.Models

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val Search: List<Movie>?,
    val totalResults: String?,
    val Response: String,
    val Error: String? = null
)
