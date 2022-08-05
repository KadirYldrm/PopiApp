package com.example.movies.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.domain.usecases.GetArtistUseCase
import com.example.movies.domain.usecases.UpdateArtistUseCase

class ArtistVMFactory(private val getArtistUseCase: GetArtistUseCase,
                      private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistVM(getArtistUseCase, updateArtistUseCase) as T
    }
}