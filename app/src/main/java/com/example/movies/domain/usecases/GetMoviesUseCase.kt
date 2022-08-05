package com.example.movies.domain.usecases

import com.example.movies.data.model.movie.Movie
import com.example.movies.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun executeGetMovie(): List<Movie>? = movieRepository.getMovies()
}