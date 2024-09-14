package com.example.myapplication.Models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.API.OMBDApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay


class MovieFetchViewModel(private val API: OMBDApi) : ViewModel() {
    var curError: String? by mutableStateOf(null)
    private var job: Job? = null
    var fetchedMovies = mutableStateOf<List<Movie>>(listOf())
        private set
    var isSearching = mutableStateOf(false)


    fun searchMovies(ourQuery: String) {
        job?.cancel()
        viewModelScope.launch {
            val isEmpty = ourQuery.isEmpty()
            if (isEmpty) {
                isSearching.value = true
                // delays for 1 second
                delay(1000)
            }
            try {
                curError = null
                val curResponse = API.searchMovies(ourQuery)
                val haveResponse = curResponse.Response == "True"
                val searchNotNull = curResponse.Search != null
                if ( haveResponse && searchNotNull) {
                    fetchedMovies.value = curResponse.Search!!
                } else {
                    if (curResponse.Error != null) {
                        curError = curResponse.Error
                    }else {
                        curError = "Could not fetch the data"
                    }
                }
                isSearching.value = false
            } catch (e: Exception) {
                isSearching.value = false
                curError = e.localizedMessage ?: "An error happened"
            }
        }
    }
}