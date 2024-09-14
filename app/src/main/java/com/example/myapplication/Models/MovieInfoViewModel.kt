import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.API.OMBDApi
import com.example.myapplication.Models.MovieInfo
import kotlinx.coroutines.launch

class MovieInfoViewModel(private val api: OMBDApi) : ViewModel() {
    var movieInfo: MovieInfo? by mutableStateOf(null)
        private set
    var isDataLoading: Boolean by mutableStateOf(false)
    var curError: String? by mutableStateOf(null)
    val True = "True"

    fun fetchMovieDetails(movieId: String) {
        viewModelScope.launch {
            try {
                isDataLoading = true
                curError = null
                val response = api.getMovieInfo(movieId)
                if (response.Response == True) {
                    movieInfo = response
                }
            } catch (e: Exception) {
                curError = "ERROR -> ${e.message}"
            } finally {
                isDataLoading = false
            }
        }
    }
}
