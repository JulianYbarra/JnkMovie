package com.junka.jnkmovie.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.junka.jnkmovie.core.loadTMDB
import com.junka.jnkmovie.core.observer
import com.junka.jnkmovie.databinding.FragmentHomeBinding
import com.junka.jnkmovie.main.base.BaseFragment
import com.junka.jnkmovie.movie.adapter.GalleryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<HomeViewModel>()

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

        val moviePopularAdapter = GalleryAdapter("Popular")

        binding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ConcatAdapter(moviePopularAdapter)
        }

        observer(viewModel.popularMovies) { movieList ->
            moviePopularAdapter.data = movieList

            movieList.firstOrNull()?.let { movie ->
                movie.backdropPath?.let {
                    binding.lastMovieImage.loadTMDB(it)
                }
                binding.lastMovieTextView.text = movie.title
            }
        }

    }
}