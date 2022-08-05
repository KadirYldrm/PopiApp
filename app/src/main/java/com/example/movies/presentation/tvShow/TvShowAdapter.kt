package com.example.movies.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val tvShowList = ArrayList<TVShow>()

    fun setList(tvshow: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

}

class ViewHolder(
        val binding: ListItemBinding
) : RecyclerView
.ViewHolder(binding.root) {

    fun bind(tvshow: TVShow) {
        binding.tvListItemName.text = tvshow.name
        binding.tvListItemDescription.text = tvshow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvshow.posterPath
        Glide.with(binding.ivListItem.context).load(posterURL).placeholder(R.drawable.loading_bg).override(1550,1550).into(binding.ivListItem)
    }
}