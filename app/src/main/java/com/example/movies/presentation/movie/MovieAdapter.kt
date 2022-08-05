package com.example.movies.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.model.movie.Movie
import com.example.movies.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}

class ViewHolder(
        val binding: ListItemBinding
) : RecyclerView
.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.tvListItemName.text = movie.title
        binding.tvListItemDescription.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.ivListItem.context).load(posterURL).placeholder(R.drawable.loading_bg)
                .override(1550, 1000).into(binding.ivListItem)
    }
}