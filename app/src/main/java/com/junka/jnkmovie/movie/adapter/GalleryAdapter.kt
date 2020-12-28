package com.junka.jnkmovie.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.junka.jnkmovie.databinding.LayoutItemGalleryBinding
import com.junka.jnkmovie.movie.model.Movie
import kotlin.properties.Delegates

class GalleryAdapter(private val title: String) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    var data: List<Movie> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: LayoutItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String, movieList: List<Movie>) = with(binding) {
            val moviesAdapter = MoviesAdapter(){}
            sectionRecyclerView.apply {
                layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = moviesAdapter
            }
            moviesAdapter.submitList(movieList)

            sectionTitle.text = title
            sectionViewMoreButton.text = "View More"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(title, data)
    }

    override fun getItemCount(): Int = 1
}