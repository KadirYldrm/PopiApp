package com.example.movies.data.repository.tvshow.datasourceImpl

import com.example.movies.data.api.TMDBService

import com.example.movies.data.model.tvshow.TVShowList
import com.example.movies.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
        private val tmdbService: TMDBService,
        private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TVShowList> =
            tmdbService.getPopularTvShows(apiKey)

}