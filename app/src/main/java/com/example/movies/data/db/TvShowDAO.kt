package com.example.movies.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.data.model.tvshow.TVShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow: List<TVShow>)

    @Query("DELETE FROM popular_shows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_shows")
    suspend fun getTvShow(): List<TVShow>
}