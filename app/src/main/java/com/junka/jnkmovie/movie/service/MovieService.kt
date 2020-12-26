package com.junka.jnkmovie.movie.service

import com.junka.jnkmovie.movie.model.MovieDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("api_key") api_key: String) : MovieDataResponse
}