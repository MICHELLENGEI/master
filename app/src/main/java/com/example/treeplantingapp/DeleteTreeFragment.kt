package com.example.treeplantingapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.treeplantingapp.data.Plant
import com.example.treeplantingapp.data.TreeDatabase
import com.example.treeplantingapp.databinding.FragmentDeleteTreeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DeleteTreeFragment : Fragment() {

    private lateinit var binding: FragmentDeleteTreeBinding
    private lateinit var treeDatabase: TreeDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteTreeBinding.inflate(layoutInflater)
        treeDatabase = TreeDatabase.getDatabase(requireContext())

        binding.submitTree.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }

    private fun insertDataToDatabase() {
        val locationTree = binding.etTreeLocation.text.toString()
        val numberTree = binding.etNumber0fTrees.text
        val cutReason = binding.etReason.text.toString()

        if (inputCheck(locationTree, numberTree, cutReason)) {
            //tree object
            val plant = Plant(
                locationTree = locationTree,
                numberTree = Integer.parseInt(numberTree.toString()),
                cutReason = cutReason

            )
            //add data to database
            GlobalScope.launch(Dispatchers.IO) {
                treeDatabase.plantDao().addPlant(plant)
            }
            Toast.makeText(requireContext(), "Tree added Successfully", Toast.LENGTH_LONG).show()
            //Navigate back to home
            val navController = findNavController()
            navController.navigate(R.id.action_deleteTreeFragment_to_homeFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(locationTree: String, numberTree: Editable, cutReason: String): Boolean {
        return !(TextUtils.isEmpty(locationTree) && numberTree.isEmpty() && TextUtils.isEmpty(
            cutReason
        ))
    }


}
