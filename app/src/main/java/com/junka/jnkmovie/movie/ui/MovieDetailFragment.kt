package com.junka.jnkmovie.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.junka.jnkmovie.core.MOVIE
import com.junka.jnkmovie.core.loadTMDB
import com.junka.jnkmovie.databinding.FragmentMovieDetailBinding
import com.junka.jnkmovie.main.base.BaseFragment
import com.junka.jnkmovie.movie.MovieViewModel
import com.junka.jnkmovie.movie.model.Movie

class MovieDetailFragment : BaseFragment() {

    private val binding : FragmentMovieDetailBinding  by lazy { FragmentMovieDetailBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MovieViewModel>()

    private val movieData : Movie? by lazy { arguments?.getParcelable(MOVIE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View  = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        with(binding){
            arrowBack.setOnClickListener {
                it.findNavController().popBackStack()
            }
            movieData?.let { movie ->
                movie.backdropPath?.let {
                    backDropImage.loadTMDB(it)
                }
                posterImage.loadTMDB(movie.posterPath)
                titleTextView.text = movie.title
                overviewTextView.text = movie.overview

                textRating.text = "${movie.voteAverage} (${movie.voteCount})"
                textReleased.text = movie.releaseDate
                textLanguage.text = movie.originalLanguage
            }
        }
    }
}