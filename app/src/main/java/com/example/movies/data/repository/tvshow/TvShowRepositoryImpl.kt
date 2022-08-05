package com.example.movies.data.repository.tvshow

import android.util.Log
import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.movies.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.movies.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.movies.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource) : TvShowsRepository {

    override suspend fun getTvShows(): List<TVShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newListOfMovies = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfMovies)
        tvShowCacheDataSource.saveTvShowToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getTvShowsFromAPI(): List<TVShow> {

        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TVShow> {

        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TVShow> {

        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}