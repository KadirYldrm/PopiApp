package com.example.movies.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movies.R
import com.example.movies.databinding.AcMainBinding
import com.example.movies.presentation.artist.FRArtist
import com.example.movies.presentation.movie.FRMovie
import com.example.movies.presentation.tvShow.FRTvShow

class ACMain : AppCompatActivity() {

    private lateinit var binding: AcMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = AcMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadFragment(FRMovie())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bnMovieItem->loadFragment(FRMovie())
                R.id.bnArtistItem->loadFragment(FRArtist())
                R.id.bnTvShowItem->loadFragment(FRTvShow())
                else->{

                }
            }
            true
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flMain, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}