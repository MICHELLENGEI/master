package com.example.treeplantingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.treeplantingapp.databinding.ActivityForgotPasswordBinding
import com.example.treeplantingapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btnReset.setOnClickListener {
            val email = binding.forgotPasswordEmailAddress.text.toString()
            if (checkAllField()){
                auth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if(it.isSuccessful){
                        auth.signOut()
                        Toast.makeText(this,"Email Sent",Toast.LENGTH_SHORT).show()
                        val intentLogin = Intent(this,Login::class.java)
                        startActivity(intentLogin)
                        finish()
                    }
                    else{
                        Log.e("error: ", it.exception.toString())
                    }
                }
            }

        }
        btnCancel.setOnClickListener {
            val intentCancel = Intent(this,MainActivity::class.java)
            startActivity(intentCancel)
            finish()
        }
    }

    private fun checkAllField(): Boolean {

        val emailS = binding.forgotPasswordEmailAddress.text.toString()
        if (binding.forgotPasswordEmailAddress.text.toString() == "") {
            Toast.makeText(this, "Email is a required field", Toast.LENGTH_LONG).show()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailS).matches()) {
            Toast.makeText(this, "Check the Email Format", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}
