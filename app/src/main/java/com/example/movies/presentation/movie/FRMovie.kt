package com.example.movies.presentation.movie

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.databinding.FrMovieBinding
import com.example.movies.presentation.di.Injector
import javax.inject.Inject


class FRMovie : Fragment(R.layout.fr_movie) {


    @Inject
    lateinit var factory: MovieVMFactory
    private lateinit var movieViewModel: MovieVM
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: FrMovieBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieVM::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FrMovieBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)

        initRecyclerView()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_update, menu)
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

    private fun initRecyclerView() {

        with(binding) {
            rvMovie.layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter()
            rvMovie.adapter = adapter
            displayPopularMovies()
        }
    }

    private fun displayPopularMovies() {

        binding.pbMovie.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            } else {
                binding.pbMovie.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateMovies() {

        binding.pbMovie.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            } else {
                binding.pbMovie.visibility = View.GONE
            }
        })
    }


}