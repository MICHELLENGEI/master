package com.example.treeplantingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHomeLogin.setOnClickListener {
            val intentLogin = Intent(this,Login::class.java)
            startActivity(intentLogin)
        }
            btnHomeSignup.setOnClickListener {
                val intentSignup = Intent(this,Signup::class.java)
                startActivity(intentSignup)
            }
        textView2.setOnClickListener {
            val intentPassword = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intentPassword)
        }
        }
    }
