package com.example.leeson1_nadav

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {


    lateinit var continueBtn : Button

    lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        continueBtn = findViewById(R.id.continueOrder_secondActivity)
        radioGroup = findViewById(R.id.pizzaSize_rg)

        continueBtn.isEnabled = false

        radioGroup.setOnCheckedChangeListener { rg, i ->
            if(!continueBtn.isEnabled)
                continueBtn.isEnabled = true

            val selected = getCheckedOption()

            Snackbar.make(rg,selected,Snackbar.LENGTH_LONG).show()

        }

        continueBtn.setOnClickListener {

            val selected = getCheckedOption()

            val thirdActivityIntent = Intent(this,ThirdActivity::class.java)

            thirdActivityIntent.putExtra("size",selected)
            thirdActivityIntent.putExtra("name", intent.getStringExtra("name"))

            startActivity(thirdActivityIntent)
        }

        val layout = findViewById<LinearLayout>(R.id.secondActivityLayout)
        val name = intent.getStringExtra("name")

        Snackbar.make(layout, "Hello $name , you may continue with your order" , Snackbar.LENGTH_LONG).show()
    }


    fun getCheckedOption() : String {
        return when(radioGroup.checkedRadioButtonId) {
            R.id.small_pizza_size_opt -> {
                "small"
            }

            R.id.medium_pizza_size_opt -> {
                "medium"
            }

            R.id.large_pizza_size_opt -> {
                "large"
            }
            else -> ""
        }
    }
}