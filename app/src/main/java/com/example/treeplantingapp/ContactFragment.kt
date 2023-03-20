package com.example.treeplantingapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.treeplantingapp.databinding.FragmentAddTreeBinding
import com.example.treeplantingapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding:FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSendMail.setOnClickListener {
           val email =binding.editTextTextEmailAddress.text.toString()
            val subject =binding.editTextTextSubject.text.toString()
            val message =binding.editTextTextMessage.text.toString()

            val addresses = email.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto")
                putExtra(Intent.EXTRA_EMAIL,addresses)
                putExtra(Intent.EXTRA_SUBJECT,subject)
                putExtra(Intent.EXTRA_TEXT,message)
            }

        }

    }


}