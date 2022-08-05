package com.example.movies.data.repository.artist.datasource

import com.example.movies.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}