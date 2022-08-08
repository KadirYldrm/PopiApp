package com.example.movies.presentation.artist

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.databinding.FrArtistBinding
import com.example.movies.presentation.di.Injector
import javax.inject.Inject

class FRArtist : Fragment(R.layout.fr_artist) {

    @Inject
    lateinit var factory: ArtistVMFactory
    private lateinit var artistViewModel: ArtistVM
    private lateinit var binding: FrArtistBinding
    private lateinit var adapter: ArtistAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistVM::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FrArtistBinding.inflate(inflater, container, false)
        val view = binding.root
        setHasOptionsMenu(true)
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {

        with(binding) {
            rvArtist.layoutManager = LinearLayoutManager(context)
            adapter = ArtistAdapter()
            rvArtist.adapter = adapter
            displayPopularMovies()
        }
    }

    private fun displayPopularMovies() {

        binding.pbArtist.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbArtist.visibility = View.GONE
            } else {
                binding.pbArtist.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {

        binding.pbArtist.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbArtist.visibility = View.GONE
            } else {
                binding.pbArtist.visibility = View.GONE
            }
        })
    }

}