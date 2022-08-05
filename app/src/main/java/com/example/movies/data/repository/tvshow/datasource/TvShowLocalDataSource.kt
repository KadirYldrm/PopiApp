package com.example.movies.data.repository.tvshow.datasource

import com.example.movies.data.model.tvshow.TVShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromDB(): List<TVShow>
    suspend fun saveTvShowToDB(tvShow: List<TVShow>)
    suspend fun clearAll()
}