package com.example.movies.presentation.di.tvshow

import com.example.movies.presentation.tvShow.FRTvShow
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: FRTvShow)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}