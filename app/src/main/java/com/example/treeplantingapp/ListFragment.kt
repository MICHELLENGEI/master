package com.example.treeplantingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treeplantingapp.data.Tree
import com.example.treeplantingapp.data.TreeViewModel
import com.example.treeplantingapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private lateinit var mTreeViewModel: TreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)

        //Recyclerview
        val adapter = PlantedTreesListAdapter(emptyList<Tree>())
        val recyclerView = binding.ListRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //userViewModel
        mTreeViewModel = ViewModelProvider(this)[TreeViewModel::class.java]
        mTreeViewModel.readAllData.observe(viewLifecycleOwner, Observer { tree ->
            adapter.setData(tree)
        })

        binding.floatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addTreeFragment)
        }
        return binding.root
    }
}