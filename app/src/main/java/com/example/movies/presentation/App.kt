package com.example.movies.presentation

import android.app.Application
import com.example.movies.BuildConfig
import com.example.movies.presentation.di.Injector
import com.example.movies.presentation.di.artist.ArtistSubComponent
import com.example.movies.presentation.di.core.*
import com.example.movies.presentation.di.movie.MovieSubComponent
import com.example.movies.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule(BuildConfig.BASE_URL))
                .remoteDM(RemoteDM(BuildConfig.API_KEY)).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}