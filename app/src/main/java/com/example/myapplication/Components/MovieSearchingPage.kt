package com.example.myapplication.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.Models.MovieFetchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.RetrofitConfig

@Composable
fun ErrorText(viewModel: MovieFetchViewModel) {
    Text(
        text = viewModel.curError!!,
        style = MaterialTheme.typography.titleLarge,
        color = Color.Red,
        modifier = Modifier
            .background(Color.LightGray)
            .border(1.dp, Color.Black)
            .padding(16.dp)
    )
}

var searchMovie = "Search Movie"


@Composable
fun MovieSearchingPage(navController: NavHostController) {
    var isSearching by remember { mutableStateOf("") }
    val viewModel: MovieFetchViewModel = viewModel {
        MovieFetchViewModel(RetrofitConfig.omdbApiService)
    }
    Column(modifier = Modifier
        .padding(17.dp)) {
        OutlinedTextField(
            modifier= Modifier.fillMaxWidth(),
            onValueChange = { newText ->
                isSearching = newText
                viewModel.searchMovies(isSearching)
            },
            value = isSearching,
            label = { Text(searchMovie) },
        )
        Spacer(modifier = Modifier.height(25.dp))
        MovieSearchStateHandler(viewModel, navController)
    }
}



