package com.example.treeplantingapp

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.treeplantingapp.data.County
import com.example.treeplantingapp.databinding.FragmentRecommendationBinding


class RecommendationFragment : Fragment() {
    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!
    private lateinit var countyTreeAdapter: CountyTreeAdapter
    private var displayList = arrayListOf<CountyTree>()


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
        val items = arrayOf<County>(
            County(code = 1, name = "Meru"),
            County(code = 2, "Baringo"),
            County(code = 3, "Taita Taveta"),
            County(code = 4, "Kitui")
        )
        val countyNames = arrayListOf<String>()
        items.forEach { countyNames.add(it.name) }

        // Initialize the spinner adapter
        val adapter = ArrayAdapter(requireContext(),
            R.layout.simple_spinner_dropdown_item, countyNames.toArray())

        spinner.adapter = adapter

        // Set an on item selected listener on the spinner

        val countyTreeViewModel: CountyTreeViewModel = ViewModelProvider(this)[CountyTreeViewModel::class.java]

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long,
            ) {
                val currentItem = items[position]
                displayList = countyTreeViewModel.getDisplayList(currentItem.code)

               initRecyclerView()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

      //  initRecyclerView()
    }


    private fun initRecyclerView() {
        countyTreeAdapter = CountyTreeAdapter(displayList)
        binding.recyclerView.apply {
            adapter = countyTreeAdapter
        }
    }

}

