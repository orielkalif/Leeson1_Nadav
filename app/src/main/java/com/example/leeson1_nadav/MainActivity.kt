package com.example.leeson1_nadav

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var nameEt: EditText
    lateinit var continueToOrderBtr: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEt = findViewById(R.id.nameEt)
        continueToOrderBtr = findViewById(R.id.continueToOrderBtr)

        continueToOrderBtr.setOnClickListener {

            val name = nameEt.text.toString()

            if(name.isEmpty()) {
                Snackbar.make(nameEt,"Please enter your name",Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this,SecondActivity::class.java)

            intent.putExtra("name" , name)

            startActivity(intent)
        }

    }
}