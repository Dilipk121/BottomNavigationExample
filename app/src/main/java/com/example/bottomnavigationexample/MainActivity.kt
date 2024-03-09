package com.example.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceWithFragment(HomeFragment()) //by default home Fragment should be there


        bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceWithFragment(HomeFragment())
                R.id.focus -> replaceWithFragment(FocusFragment())
                R.id.profile -> replaceWithFragment(ProfileFragment())
                else -> { }
            }
            true
        // return true....without writing return!!
        }


    }

    private fun replaceWithFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }
}