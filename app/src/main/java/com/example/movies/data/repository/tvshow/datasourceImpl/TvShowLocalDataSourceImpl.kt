package com.example.movies.data.repository.tvshow.datasourceImpl

import com.example.movies.data.db.TvShowDAO
import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO) : TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TVShow> {
        return tvShowDAO.getTvShow()
    }

    override suspend fun saveTvShowToDB(tvShow: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShow()
        }
    }
}