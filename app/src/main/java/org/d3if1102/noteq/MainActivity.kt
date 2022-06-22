package org.d3if1102.noteq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import org.d3if1102.noteq.util.MyTimer

class MainActivity : AppCompatActivity() {

    private lateinit var myTimer: MyTimer
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController=navHostFragment.navController

        setupActionBarWithNavController(navController)
        myTimer = MyTimer()

        Log.i("MainActivity", "onCreate dijalankan")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart dijalankan")
        myTimer.startTimer()
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume dijalankan")
    }
    override fun onPause() {
        Log.i("MainActivity", "onPause dijalankan")
        super.onPause()
    }
    override fun onStop() {
        Log.i("MainActivity", "onStop dijalankan")
        myTimer.stopTimer()
        super.onStop()
    }
    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy dijalankan")
        super.onDestroy()
    }
}