package com.example.movies.domain.usecases

import com.example.movies.data.model.artist.Artist
import com.example.movies.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun executeUpdateArtist(): List<Artist>? = artistRepository.updateArtist()
}