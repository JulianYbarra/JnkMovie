package com.junka.jnkmovie.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.junka.jnkmovie.core.observer
import com.junka.jnkmovie.databinding.FragmentMovieBinding
import com.junka.jnkmovie.main.base.BaseFragment
import com.junka.jnkmovie.movie.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment() {

    private val binding by lazy { FragmentMovieBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieAdapter = MoviesAdapter()

        binding.moviesRecyclerView.apply {
            adapter = movieAdapter
        }

        observer(viewModel.popularMovies) { movieList ->
            movieAdapter.submitList(movieList)
        }

    }
}