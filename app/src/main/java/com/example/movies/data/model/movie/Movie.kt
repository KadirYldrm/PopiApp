package com.example.movies.data.model.movie


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movie")
data class Movie(

        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        val uid: Int,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        @SerializedName("title")
        val title: String?
)