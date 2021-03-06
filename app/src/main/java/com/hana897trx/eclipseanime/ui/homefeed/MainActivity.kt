package com.hana897trx.eclipseanime.ui.homefeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.hana897trx.eclipseanime.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_home) as NavHostFragment
        val navController = navHostFragment.navController

        navController.graph = navController.navInflater.inflate(R.navigation.navigation_main)
    }
}