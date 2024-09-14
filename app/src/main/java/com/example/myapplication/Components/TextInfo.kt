package com.example.myapplication.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.Models.Movie

@Composable
fun TextInfo(movie: Movie) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(movie.Title, style = MaterialTheme.typography.bodyLarge)
        Text(movie.Year, style = MaterialTheme.typography.bodyMedium)
    }
}
