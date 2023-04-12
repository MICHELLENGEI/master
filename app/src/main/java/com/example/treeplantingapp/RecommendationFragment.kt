package com.example.treeplantingapp

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.treeplantingapp.databinding.FragmentRecommendationBinding


class RecommendationFragment : Fragment() {
    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!
    private lateinit var meruAdapter: MeruAdapter
    private var meruList = arrayListOf<Meru>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecommendationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = binding.locationSpinner
        //Create an array of items for the spinner
        val items = arrayOf(
            "Meru",
            "Kitui"
        )
        // Initialize the spinner adapter
        var adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter

        // Set an on item selected listener on the spinner

        val meruViewModel: MeruViewModel = ViewModelProvider(this)[MeruViewModel::class.java]
        meruList = meruViewModel.meruList

        initRecyclerView()

    }

    private fun initRecyclerView() {
        meruAdapter = MeruAdapter(meruList)
        binding.recyclerView.apply {
            adapter = meruAdapter
        }
    }

}

