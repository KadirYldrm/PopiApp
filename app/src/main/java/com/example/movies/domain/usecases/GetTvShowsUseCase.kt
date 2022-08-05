package com.example.movies.domain.usecases

import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun executeGetTvShows(): List<TVShow>? = tvShowsRepository.getTvShows()
}