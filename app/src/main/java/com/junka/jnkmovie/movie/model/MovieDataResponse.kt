package com.junka.jnkmovie.movie.model

import com.google.gson.annotations.SerializedName

data class MovieDataResponse(
    val page : Int,
    val results : List<Movie>,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int
)