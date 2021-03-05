package net.pradana.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.pradana.movie.databinding.ActivityMainBinding
import net.pradana.movie.ui.movie.MovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setupPager()
    }

    private fun setupPager(){
        val pagerAdapter = MainPager(supportFragmentManager)
        pagerAdapter.addFragment(MovieFragment(), "Movie")
        binding.mainViewpager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.mainViewpager)
    }
}