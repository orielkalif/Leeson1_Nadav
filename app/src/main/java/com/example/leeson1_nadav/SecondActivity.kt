package com.example.leeson1_nadav

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val layout = findViewById<LinearLayout>(R.id.secondActivityLayout)
        val name = intent.getStringExtra("name")

        Snackbar.make(layout , "Hello $name , you may continue with your order" , Snackbar.LENGTH_LONG).show()
    }
}