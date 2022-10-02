package com.example.leeson1_nadav

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val layout = findViewById<LinearLayout>(R.id.thirdLayout)

        val name = intent.getStringExtra("name")
        val size = intent.getStringExtra("size")
        Snackbar.make(layout,"Thank you $name, you have selected : $size",Snackbar.LENGTH_LONG).show()
    }
}