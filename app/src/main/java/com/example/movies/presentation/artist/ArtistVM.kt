package com.example.movies.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movies.domain.usecases.GetArtistUseCase
import com.example.movies.domain.usecases.UpdateArtistUseCase

class ArtistVM(private val getArtistUseCase: GetArtistUseCase,
               private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.executeGetArtist()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistUseCase.executeUpdateArtist()
        emit(artistList)
    }
}