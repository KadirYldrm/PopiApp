package com.example.movies.presentation.di.core

import com.example.movies.data.repository.artist.ArtistRepositoryImpl
import com.example.movies.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.movies.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.movies.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.movies.data.repository.movie.MovieRepositoryImpl
import com.example.movies.data.repository.movie.datasource.MovieCacheDataSource
import com.example.movies.data.repository.movie.datasource.MovieLocalDataSource
import com.example.movies.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.movies.data.repository.tvshow.TvShowRepositoryImpl
import com.example.movies.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.movies.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.movies.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.movies.domain.repository.ArtistRepository
import com.example.movies.domain.repository.MovieRepository
import com.example.movies.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource,
                               movieLocalDataSource: MovieLocalDataSource,
                               movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(movieRemoteDataSource,
                movieCacheDataSource,
                movieLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowCacheDataSource: TvShowCacheDataSource,
                                tvShowLocalDataSource: TvShowLocalDataSource,
                                tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowsRepository {

        return TvShowRepositoryImpl(tvShowRemoteDataSource,
                tvShowCacheDataSource,
                tvShowLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(artistRemoteDataSource: ArtistRemoteDataSource,
                                artistLocalDataSource: ArtistLocalDataSource,
                                artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(artistRemoteDataSource,
                artistLocalDataSource,
                artistCacheDataSource
        )
    }
}