package com.example.treeplantingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.treeplantingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHomeLogin.setOnClickListener {
            val intentLogin = Intent(this, Login::class.java)
            startActivity(intentLogin)
        }
        binding.btnHomeSignup.setOnClickListener {
            val intentSignup = Intent(this, Signup::class.java)
            startActivity(intentSignup)
        }
        binding.textView2.setOnClickListener {
            val intentPassword = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentPassword)
        }
    }
}
