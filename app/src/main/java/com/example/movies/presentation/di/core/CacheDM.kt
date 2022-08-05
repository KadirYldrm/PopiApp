package com.example.movies.presentation.di.core

import com.example.movies.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.movies.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.movies.data.repository.movie.datasource.MovieCacheDataSource
import com.example.movies.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.movies.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.movies.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDM {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}