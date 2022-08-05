package com.example.movies.data.repository.artist

import android.util.Log
import com.example.movies.data.model.artist.Artist
import com.example.movies.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.movies.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.movies.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.movies.domain.repository.ArtistRepository

class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {

            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }

        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}