package com.example.myapplication

import com.example.myapplication.API.OMBDApi
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

object RetrofitConfig {
    private val retrofit: Retrofit = initializeRetrofit()

    val omdbApiService: OMBDApi by lazy {
        retrofit.create(OMBDApi::class.java)
    }

    private fun initializeRetrofit(): Retrofit {
        val jsonConfig = Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
        }
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(jsonConfig.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}
