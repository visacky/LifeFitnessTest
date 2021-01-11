package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*
import android.content.Intent



class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        coinChange.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startIntent(intent)
        }
        twoDimensionButton.setOnClickListener {
            val intent = Intent(this, TwoDimensionalArrayTest::class.java)
            startIntent(intent)
        }
        locationUpdateButton.setOnClickListener {
            val intent = Intent(this, LocationUpdate::class.java)
            startIntent(intent)
        }
    }

    private fun startIntent(intent:Intent){
        startActivity(intent)
    }
}
