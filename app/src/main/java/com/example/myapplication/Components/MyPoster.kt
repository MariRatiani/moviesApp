package com.example.myapplication.Components

import MovieInfoViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MyPoster(viewModel: MovieInfoViewModel) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),

        contentDescription = "Movie Poster",
        painter = rememberAsyncImagePainter(model = viewModel.movieInfo?.Poster),
        contentScale = ContentScale.FillHeight
    )
}
