package com.example.myapplication

import com.example.myapplication.API.OmdbApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.junit.Test
import retrofit2.Retrofit

class WebServerTest {
    @Test
    fun `test API fetches data correctly`() = runBlocking {
        // Initialize Retrofit with the base URL of the OMDb API
        val api = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(OmdbApi::class.java)

        // Make an API request to search for the movie "Batman" and validate the response
        val response = api.searchMovies("Batman", "f74adde2")  // Replace "your_api_key" with your actual OMDb API key
        assertTrue("The search should return at least one result", response.Search?.isNotEmpty() == true)
    }
//    @Composable
//    @Test
//    fun `Test API fetches data correctly`() {
//        val api = RetrofitInstance.api
//        val viewModel: MovieViewModel = viewModel(factory = MovieViewModelFactory(api))
//        val searchText = "Batman"
//        viewModel.searchMovies(searchText)
//        val movies = viewModel.movies.value
//        Assert.assertEquals(movies.isEmpty(), false)
//    }
}