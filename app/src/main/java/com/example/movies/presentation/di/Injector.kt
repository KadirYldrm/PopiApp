package com.example.movies.presentation.di

import com.example.movies.presentation.di.artist.ArtistSubComponent
import com.example.movies.presentation.di.movie.MovieSubComponent
import com.example.movies.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}