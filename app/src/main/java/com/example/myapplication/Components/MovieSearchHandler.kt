package com.example.myapplication.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Models.MovieFetchViewModel


@Composable
fun MovieSearchStateHandler(viewModel: MovieFetchViewModel, controller: NavHostController) {
    when {
        viewModel.isSearching.value -> {
            CircularProgressIndicator()
        }
        viewModel.curError != null -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
            ) {
                ErrorText(viewModel)
            }
        }
        viewModel.fetchedMovies.value.isEmpty() -> {
            NoMovies()
        }
        else -> {
            LazyColumn {
                items(viewModel.fetchedMovies.value) { movie ->
                    MovieCard(movie, controller)
                }
            }
        }
    }
}

