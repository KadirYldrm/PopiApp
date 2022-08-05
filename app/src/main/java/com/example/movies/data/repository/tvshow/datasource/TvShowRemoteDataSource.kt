package com.example.movies.data.repository.tvshow.datasource

import com.example.movies.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShow(): Response<TVShowList>
}