package com.example.myapplication

import MoviePage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Components.MovieSearchingPage

import androidx.navigation.compose.NavHost
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Routes.MovieSearch.route) {
            composable(Routes.MovieSearch.route) {
                MovieSearchingPage(navController)
            }
            composable(Routes.MovieDetails.route) { a ->
                a.arguments?.getString("movieId")?.also { id ->
                    MoviePage(id, navController)
                }
            }
        }
    }

    object Routes {
        object MovieSearch {
            const val route = "movieSearch"
        }
        object MovieDetails {
            const val route = "movieDetails/{movieId}"
        }
    }
}