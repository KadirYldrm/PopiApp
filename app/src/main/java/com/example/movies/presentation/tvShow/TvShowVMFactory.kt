package com.example.movies.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.domain.usecases.GetTvShowsUseCase
import com.example.movies.domain.usecases.UpdateTvShowsUseCase

class TvShowVMFactory(private val getTvShowsUseCase: GetTvShowsUseCase,
                      private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowVM(getTvShowsUseCase, updateTvShowsUseCase) as T
    }


}