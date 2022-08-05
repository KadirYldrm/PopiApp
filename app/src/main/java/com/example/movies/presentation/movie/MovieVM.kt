package com.example.movies.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movies.domain.usecases.GetMoviesUseCase
import com.example.movies.domain.usecases.UpdateMoviesUseCase


class MovieVM(private val getMoviesUseCase: GetMoviesUseCase,
              private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.executeGetMovie()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.executeUpdateMovie()
        emit(movieList)
    }

}