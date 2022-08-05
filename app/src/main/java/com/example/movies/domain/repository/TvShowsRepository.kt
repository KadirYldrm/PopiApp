package com.example.movies.domain.repository

import com.example.movies.data.model.tvshow.TVShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TVShow>?
    suspend fun updateTvShows(): List<TVShow>?
}