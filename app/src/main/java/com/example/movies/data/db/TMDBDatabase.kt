package com.example.movies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies.data.model.artist.Artist
import com.example.movies.data.model.movie.Movie
import com.example.movies.data.model.tvshow.TVShow

@Database(entities = [Movie::class,
    TVShow::class,
    Artist::class],
        version = 1,
        exportSchema = false)

abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    abstract fun tvDAO(): TvShowDAO
    abstract fun artistDAO(): ArtistDAO
}