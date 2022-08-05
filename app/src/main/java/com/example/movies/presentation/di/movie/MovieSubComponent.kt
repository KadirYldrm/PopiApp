package com.example.movies.presentation.di.movie

import com.example.movies.presentation.movie.FRMovie
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieFragment: FRMovie)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}