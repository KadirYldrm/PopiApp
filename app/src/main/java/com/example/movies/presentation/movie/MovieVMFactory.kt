package com.example.movies.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.domain.usecases.GetMoviesUseCase
import com.example.movies.domain.usecases.UpdateMoviesUseCase

class MovieVMFactory(private val getMoviesUseCase: GetMoviesUseCase,
                     private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieVM(getMoviesUseCase, updateMoviesUseCase) as T
    }

}