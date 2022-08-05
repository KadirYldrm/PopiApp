package com.example.movies.domain.repository

import com.example.movies.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovie(): List<Movie>?
}