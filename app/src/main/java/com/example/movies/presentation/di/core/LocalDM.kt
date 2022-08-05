package com.example.movies.presentation.di.core

import com.example.movies.data.db.ArtistDAO
import com.example.movies.data.db.MovieDAO
import com.example.movies.data.db.TvShowDAO
import com.example.movies.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.movies.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.movies.data.repository.movie.datasource.MovieLocalDataSource
import com.example.movies.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.movies.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.movies.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDM {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }
}