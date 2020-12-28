package com.junka.jnkmovie.main.communication

import com.junka.jnkmovie.movie.model.Movie

sealed class MainAction {
    class OnShowMovieDetail(val movie : Movie) : MainAction()
}