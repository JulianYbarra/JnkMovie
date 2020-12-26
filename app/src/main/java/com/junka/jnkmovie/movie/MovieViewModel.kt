package com.junka.jnkmovie.movie

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.junka.jnkmovie.core.API_KEY
import com.junka.jnkmovie.movie.controller.MovieController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel @ViewModelInject constructor(
    private val movieController: MovieController) : ViewModel() {


    val popularMovies = movieController.getMoviePopular(API_KEY).asLiveData()

    fun getMoviePopular() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                movieController.getMoviePopular(API_KEY).collect { results ->
                    Log.d("TAG", "getMoviePopular: $results")
                }
            }
        }
    }
}