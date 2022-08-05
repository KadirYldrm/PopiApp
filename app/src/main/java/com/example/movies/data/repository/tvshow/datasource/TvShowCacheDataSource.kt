package com.example.movies.data.repository.tvshow.datasource

import com.example.movies.data.model.tvshow.TVShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TVShow>
    suspend fun saveTvShowToCache(tvShow: List<TVShow>)
}