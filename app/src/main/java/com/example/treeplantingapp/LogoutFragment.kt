package com.example.treeplantingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.treeplantingapp.databinding.FragmentLogoutBinding
import com.google.firebase.auth.FirebaseAuth


class LogoutFragment : Fragment() {
    private lateinit var binding: FragmentLogoutBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLogoutBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buttonLogoutFrag.setOnClickListener {
            auth.signOut()
            val navController = findNavController()
            navController.navigate(R.id.mainActivity)
        }
        binding.buttonCancelFrag.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.homeFragment)
        }
    }

}