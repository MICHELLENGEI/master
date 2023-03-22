package com.example.treeplantingapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.treeplantingapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.buttonSignUp.setOnClickListener {
            val email = binding.eTSignupEmailAddress.text.toString()
            val password = binding.eTSignupNumberPassword.text.toString()
            if (checkAllField()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        auth.signOut()
                        Toast.makeText(this, "Account created Successfully", Toast.LENGTH_SHORT)
                            .show()
                        val intentSignup = Intent(this, HomeActivity::class.java)
                        startActivity(intentSignup)
                        finish()
                    } else {
                        Log.e("error: ", task.exception.toString())
                    }
                }
            }
        }
        binding.textView6.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

    private fun checkAllField(): Boolean {

        val emailS = binding.eTSignupEmailAddress.text.toString()
        if (binding.eTSignupEmailAddress.text.toString() == "") {
            Toast.makeText(this, "Email is a required field", Toast.LENGTH_LONG).show()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailS).matches()) {
            Toast.makeText(this, "Check the Email Format", Toast.LENGTH_LONG).show()
            return false
        }
        if (binding.eTSignupNumberPassword.text.toString() == "") {
            Toast.makeText(this, "Password is a required field", Toast.LENGTH_LONG).show()
            return false
        }
        if (binding.eTSignupNumberPassword.length() <= 6) {
            Toast.makeText(this, "Password should be at least 8 characters", Toast.LENGTH_LONG)
                .show()
            return false
        }
        return true
    }
}