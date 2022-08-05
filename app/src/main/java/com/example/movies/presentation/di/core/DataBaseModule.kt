package com.example.movies.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.movies.data.db.ArtistDAO
import com.example.movies.data.db.MovieDAO
import com.example.movies.data.db.TMDBDatabase
import com.example.movies.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDAO()
    }

    @Singleton
    @Provides
    fun provideTvShowDAO(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvDAO()
    }

    @Singleton
    @Provides
    fun provideArtistDAO(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDAO()
    }
}