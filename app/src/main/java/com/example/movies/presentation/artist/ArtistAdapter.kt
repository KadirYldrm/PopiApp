package com.example.movies.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.model.artist.Artist
import com.example.movies.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>) {
        artistList.clear()
        artistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

}

class ViewHolder(
        val binding: ListItemBinding
) : RecyclerView
.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.tvListItemName.text = artist.name
        binding.tvListItemDescription.text = artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.ivListItem.context).load(posterURL).placeholder(R.drawable.loading_bg)
                .override(1550, 1000).into(binding.ivListItem)
    }
}