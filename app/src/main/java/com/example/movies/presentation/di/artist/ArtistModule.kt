package com.example.movies.presentation.di.artist

import com.example.movies.domain.usecases.GetArtistUseCase
import com.example.movies.domain.usecases.UpdateArtistUseCase
import com.example.movies.presentation.artist.ArtistVMFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistUseCase: GetArtistUseCase,
                                      updateArtistUseCase: UpdateArtistUseCase
    ): ArtistVMFactory {
        return ArtistVMFactory(getArtistUseCase, updateArtistUseCase)
    }
}