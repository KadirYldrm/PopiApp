package com.example.movies.domain.usecases

import com.example.movies.data.model.artist.Artist
import com.example.movies.domain.repository.ArtistRepository


class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun executeGetArtist(): List<Artist>? = artistRepository.getArtists()
}