package com.test.empore.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.test.empore.App
import com.test.empore.R
import com.test.empore.databinding.ActivityMainBinding
import com.test.empore.ui.fragment.FavoriteFragment
import com.test.empore.ui.fragment.HomeFragment
import com.test.empore.ui.fragment.RecentFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as App).appComponent.inject(this)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        /* Bottom Navigation Bar Setup */
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_view) as NavHostFragment?
        val navController = navHostFragment?.navController

        Navigation.setViewNavController(binding.navView, navController)

        /* Fragments */
        val homeFragment: Fragment = HomeFragment.newInstance()
        val favoriteFragment: Fragment = FavoriteFragment.newInstance()
        val recentFragment: Fragment = RecentFragment.newInstance()

        /* Open Default Fragment */
        openFragment(homeFragment)

        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    openFragment(homeFragment)
                    toolbar.title = "Home"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_favorite -> {
                    openFragment(favoriteFragment)
                    toolbar.title = "Favorit"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_recent -> {
                    openFragment(recentFragment)
                    toolbar.title = "Recent View"
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}