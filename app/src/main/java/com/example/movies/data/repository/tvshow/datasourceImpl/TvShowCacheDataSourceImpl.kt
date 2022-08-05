package com.example.movies.data.repository.tvshow.datasourceImpl

import com.example.movies.data.model.tvshow.TVShow
import com.example.movies.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTvShowFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}