package com.example.movies.presentation.di.artist

import com.example.movies.presentation.artist.FRArtist
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: FRArtist)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}