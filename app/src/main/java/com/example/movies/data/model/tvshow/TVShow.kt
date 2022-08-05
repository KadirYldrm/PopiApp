package com.example.movies.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_shows")
data class TVShow(

        @SerializedName("first_air_date")
        val firstAirDate: String?,
        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        val uid: Int,
        @SerializedName("name")
        val name: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("poster_path")
        val posterPath: String?
)