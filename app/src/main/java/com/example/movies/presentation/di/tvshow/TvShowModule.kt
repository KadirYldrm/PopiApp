package com.example.movies.presentation.di.tvshow

import com.example.movies.domain.usecases.GetTvShowsUseCase
import com.example.movies.domain.usecases.UpdateTvShowsUseCase
import com.example.movies.presentation.tvShow.TvShowVMFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideArtistViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase,
                                      updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowVMFactory {
        return TvShowVMFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}