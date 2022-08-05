package com.example.movies.data.repository.artist.datasource

import com.example.movies.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}