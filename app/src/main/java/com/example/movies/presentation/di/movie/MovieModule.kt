package com.example.movies.presentation.di.movie

import com.example.movies.domain.usecases.GetMoviesUseCase
import com.example.movies.domain.usecases.UpdateMoviesUseCase
import com.example.movies.presentation.movie.MovieVMFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                     updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieVMFactory {
        return MovieVMFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}