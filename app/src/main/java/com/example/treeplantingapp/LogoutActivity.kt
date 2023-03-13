package com.example.treeplantingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.treeplantingapp.databinding.ActivityLoginBinding
import com.example.treeplantingapp.databinding.ActivityLogoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogoutActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLogoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.buttonLogoutFrag.setOnClickListener {
            auth.signOut()
            val intentLogout = Intent(this,MainActivity::class.java)
            startActivity(intentLogout)
            finish()
        }
        binding.buttonCancelFrag.setOnClickListener {
            val intentLogout = Intent(this,MainActivity::class.java)
            startActivity(intentLogout)
            finish()
        }

    }
}