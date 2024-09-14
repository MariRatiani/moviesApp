package com.example.myapplication.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.Models.Movie


@Composable
fun MovieCard(movie: Movie, navController: NavHostController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .background(color = Color.White),
        onClick = {
            navController.navigate("movieDetails/${movie.imdbID}")
        }) {
        MovieInfo(movie)
    }
}

@Composable
fun MovieInfo(movie: Movie) {
    Row {
        MovieImage(movie)
        Spacer(modifier = Modifier.width(6.dp))
        TextInfo(movie)
    }
}

@Composable
fun MovieImage(movie: Movie) {
    Image(
        contentDescription = "Movie Poster",
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = movie.Poster)
                .crossfade(true)
                .build()
        ),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(130.dp, 154.dp)
            .clip(RoundedCornerShape(4.dp))
    )
}