package com.junka.jnkmovie.movie.controller

import com.junka.jnkmovie.movie.model.Movie
import com.junka.jnkmovie.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieController @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun getMoviePopular(apiKey: String): Flow<List<Movie>> = movieRepository.getMoviePopular(apiKey)
}