package com.leinaro.peiky.movies

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.ui.MovieFragment

class MainActivity : AppCompatActivity(), MovieFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(movie: Movie?) {
        //TODO Open movie detail
        Log.e("iarl", "click "+movie?.title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_popular, R.id.navigation_top_ranked, R.id.navigation_upcoming))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
