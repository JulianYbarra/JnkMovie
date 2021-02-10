package com.junka.jnkmovie.movie.repository

import com.junka.jnkmovie.movie.model.Movie
import com.junka.jnkmovie.movie.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val service: MovieService
) {

    fun getMoviePopular(apiKey: String): Flow<List<Movie>> = flow {
        emit(service.getMoviePopular(apiKey).results)
    }

    companion object {
        private const val PAGING_SIZE = 20
    }
}