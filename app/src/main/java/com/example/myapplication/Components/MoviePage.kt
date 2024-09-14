import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import com.example.myapplication.Components.MoviesInfo
import com.example.myapplication.Components.MyPoster

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.myapplication.RetrofitConfig

@Composable
fun MoviePage(ID: String, controller: NavHostController) {
    val API =  RetrofitConfig.omdbApiService
    val modelView = remember { MovieInfoViewModel(API) }

    LaunchedEffect(ID) {
        modelView.fetchMovieDetails(ID)
    }

    if (!modelView.isDataLoading) {
        MovieLoad(modelView = modelView, controller)
    } else {
        CircularProgressIndicator()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieLoad(modelView: MovieInfoViewModel, controller: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = modelView.movieInfo?.Title ?: "title could not be found") },
                navigationIcon = {
                    IconButton(onClick = { controller.navigateUp() }) {
                        MyIcon()
                    }
                }
            )}) {
                MovieDetails(modelView)
    }
}

@Composable
fun MyIcon() {
    Icon(
        contentDescription = "Back" ,
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
    )
}


@Composable
fun MovieDetails(viewModel: MovieInfoViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        MyPoster(viewModel)
        viewModel.movieInfo?.let { a -> MoviesInfo(a) }
    }
}

