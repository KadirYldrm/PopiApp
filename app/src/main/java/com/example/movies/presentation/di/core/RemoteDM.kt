package com.example.movies.presentation.di.core

import com.example.movies.data.api.TMDBService
import com.example.movies.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.movies.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.movies.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.movies.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.movies.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.movies.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDM(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}