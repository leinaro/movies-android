package com.leinaro.peiky.movies.ui.topranked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leinaro.peiky.movies.ui.MovieFragment

class TopRankedMoviesFragment : MovieFragment() {

    private lateinit var topRankedMoviesViewModel: TopRankedMoviesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)

        topRankedMoviesViewModel =
                ViewModelProviders.of(this).get(TopRankedMoviesViewModel::class.java)
        topRankedMoviesViewModel.movies.observe(this, Observer {
            it?.let {
                viewAdapter.setMovies(it)
            }
        })
        return root
    }
}