package com.example.movies.domain.repository

import com.example.movies.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}