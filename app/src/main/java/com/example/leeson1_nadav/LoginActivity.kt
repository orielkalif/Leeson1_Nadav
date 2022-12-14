package com.example.leeson1_nadav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    companion object {
        const val EMAIL_ADDRESS_INTENT : String = "EMAIL_ADDRESS_INTENT"
    }

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailEt = findViewById(R.id.emailEt)
        passwordEt = findViewById(R.id.passwordEt)
        loginBtn = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener(loginClickListener)
    }


    private val loginClickListener : (v:View) -> Unit = {

        val emailAddress = emailEt.text.toString()
        val password = passwordEt.text.toString()


        if(emailAddress.isEmpty()) {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show()
        } else if(password.isEmpty()) {
            Toast.makeText(this, "Please enter valid password", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EMAIL_ADDRESS_INTENT, emailAddress)
            startActivity(intent)
        }
    }

}