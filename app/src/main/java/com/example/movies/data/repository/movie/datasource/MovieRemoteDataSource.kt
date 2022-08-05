package com.example.movies.data.repository.movie.datasource

import com.example.movies.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}