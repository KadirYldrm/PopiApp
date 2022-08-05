package com.example.movies.presentation.tvShow

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.databinding.FrTvShowBinding
import com.example.movies.presentation.di.Injector
import com.example.movies.presentation.movie.MovieVM
import javax.inject.Inject

class FRTvShow : Fragment(R.layout.fr_tv_show) {

    @Inject
    lateinit var factory: TvShowVMFactory
    private lateinit var tvShowViewModel: TvShowVM
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: FrTvShowBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowVM::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FrTvShowBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)

        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        with(binding) {
            rvTvShow.layoutManager = LinearLayoutManager(context)
            adapter = TvShowAdapter()
            rvTvShow.adapter = adapter
            displayPopularMovies()
        }
    }

    private fun displayPopularMovies() {

        binding.pbTvShow.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShow()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbTvShow.visibility = View.GONE
            } else {
                binding.pbTvShow.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
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

    private fun updateMovies() {

        binding.pbTvShow.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShow()
        response.observe(this, Observer {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbTvShow.visibility = View.GONE
            } else {
                binding.pbTvShow.visibility = View.GONE
            }
        })
    }
}