package com.example.movies.presentation.di.core


import com.example.movies.presentation.di.artist.ArtistSubComponent
import com.example.movies.presentation.di.movie.MovieSubComponent
import com.example.movies.presentation.di.tvshow.TvShowSubComponent
import dagger.Component

import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDM::class,
    LocalDM::class,
    CacheDM::class])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}