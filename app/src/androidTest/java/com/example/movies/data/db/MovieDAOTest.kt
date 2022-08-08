package com.example.movies.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movies.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDAOTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDAO
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider
                        .getApplicationContext(), TMDBDatabase::class.java).build()

        dao = database.movieDAO()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking{
        val movies = listOf(
                Movie(1,"overview1","posterPath1","date1","title1")
        )
        dao.saveMovies(movies)
        val allMovies = dao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {

        val movies = listOf(
                Movie(1,"overview1","posterPath1","date1","title1")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()

    }
}