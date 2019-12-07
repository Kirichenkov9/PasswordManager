package com.example.password

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.password.view.AddPassFragment
import com.example.password.view.GenerateFragment
import com.example.password.view.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(HomeFragment())
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val homeFragment = HomeFragment()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_generate -> {
                val generateFragment = GenerateFragment()
                openFragment(generateFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add -> {
                val addPassFragment = AddPassFragment()
                openFragment(addPassFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
