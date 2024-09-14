package com.example.myapplication.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.Models.MovieInfo


@Composable
fun MoviesInfo(movieDetails: MovieInfo) {
    Column (modifier = Modifier.padding(12.dp) ){
        Text(
            "Director: ${movieDetails.Director}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "- ${movieDetails.Actors}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Box Office: ${movieDetails.BoxOffice}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Awards: ${movieDetails.Awards}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
