package org.d3if1102.noteq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable{
            startActivity(Intent(this, MainActivity::class.java))
        },2000)
    }
}