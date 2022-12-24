package com.keyvani.shoeapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
             navController = findNavController(R.id.navHost)
            NavigationUI.setupActionBarWithNavController(this@MainActivity,navController)

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHost)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}