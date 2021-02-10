package com.junka.jnkmovie.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.junka.jnkmovie.R
import com.junka.jnkmovie.core.observer
import com.junka.jnkmovie.databinding.FragmentMovieBinding
import com.junka.jnkmovie.main.base.BaseFragment
import com.junka.jnkmovie.main.communication.MainAction
import com.junka.jnkmovie.movie.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment() {

    private val binding by lazy { FragmentMovieBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleTextView.text = getString(R.string.app_name)

        val moviePopularAdapter = MoviesAdapter(){
            communication.onFragmentEvent(MainAction.OnShowMovieDetail(it))
        }

        binding.moviesRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),3,LinearLayoutManager.VERTICAL,false)
            adapter = ConcatAdapter(moviePopularAdapter)
        }

        observer(viewModel.popularMovies) { movieList ->
            moviePopularAdapter.submitList(movieList)
        }
    }
}