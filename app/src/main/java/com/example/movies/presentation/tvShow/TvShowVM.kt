package com.example.movies.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movies.domain.usecases.GetTvShowsUseCase
import com.example.movies.domain.usecases.UpdateTvShowsUseCase

class TvShowVM(private val getTvShowsUseCase: GetTvShowsUseCase,
               private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList = getTvShowsUseCase.executeGetTvShows()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowsUseCase.executeUpdateTvShows()
        emit(tvShowList)
    }
}