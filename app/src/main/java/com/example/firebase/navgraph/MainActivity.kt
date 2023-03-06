package com.pbs.testnavgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.firebase.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity1 : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
       navController = navHostFragment.navController
       val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bNView)

        setupWithNavController(bottomNavigationView , navController)
    }

    }