package com.example.myapplication.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("imdbID") val imdbID: String,
    @SerialName("Type") val Type: String,
    @SerialName("Year") val Year: String,
    @SerialName("Poster") val Poster: String,
    @SerialName("Title") val Title: String
)