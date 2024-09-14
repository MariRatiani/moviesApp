package com.example.myapplication.Models

import kotlinx.serialization.Serializable


@Serializable
data class MovieInfo(
    val Title: String,
    val Year: String,
    val Poster: String,
    val Error: String? = null,
    val Director: String,
    val Actors: String,
    val Plot: String,
    val Awards: String,
    val Response: String,
    val BoxOffice: String
)
