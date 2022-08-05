package com.example.movies.domain.usecases

import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun executeUpdateTvShows(): List<TVShow>? = tvShowsRepository.updateTvShows()
}