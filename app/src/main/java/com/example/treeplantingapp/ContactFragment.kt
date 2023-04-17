package com.example.treeplantingapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.treeplantingapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSendMail.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val subject = binding.editTextTextSubject.text.toString()
            val message = binding.editTextTextMessage.text.toString()
            val uri = Uri.parse("mailto:$email?subject=$subject&message=$message")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(Intent.createChooser(intent, "Send Mail"))
        }

    }

}


