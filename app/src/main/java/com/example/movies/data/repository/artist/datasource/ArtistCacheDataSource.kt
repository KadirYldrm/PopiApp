package com.example.movies.data.repository.artist.datasource

import com.example.movies.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}