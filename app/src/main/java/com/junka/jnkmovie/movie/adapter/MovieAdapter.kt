package com.junka.jnkmovie.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.junka.jnkmovie.R
import com.junka.jnkmovie.core.loadTMDB
import com.junka.jnkmovie.databinding.ViewItemMovieBinding
import com.junka.jnkmovie.movie.model.Movie

class MoviesAdapter : ListAdapter<Movie, MoviesAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_movie, parent, false)
        val binding = ViewItemMovieBinding.bind(view)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
    }

    class ItemViewHolder(private val binding: ViewItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) = with(binding) {
            movieTitle.text = item.title
            movieCover.loadTMDB(item.posterPath)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}