package com.example.treeplantingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.treeplantingapp.data.Tree
import com.example.treeplantingapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleDate: ArrayList<Tree> = arrayListOf(
            Tree(0, "Meru Oak", "", 10),
            Tree(1, "Meru Oak", "", 6),
            Tree(2, "Meru Oak", "", 4),
            Tree(3, "Meru Oak", "", 3),
            Tree(4, "Meru Oak", "", 8),
            Tree(5, "Meru Oak", "", 12),
            Tree(6, "Meru Oak", "", 16),
            Tree(7, "Meru Oak", "", 14),
            Tree(8, "Meru Oak", "", 28),
            Tree(9, "Meru Oak", "", 17),
            Tree(10, "Meru Oak", "", 9),
            Tree(11, "Meru Oak", "", 7),
            Tree(12, "Meru Oak", "", 1),
            Tree(13, "Meru Oak", "", 9),
            Tree(14, "Meru Oak", "", 9),
            Tree(15, "Meru Oak", "", 10),
            Tree(16, "Meru Oak", "", 18),
        )
        val listAdapter = PlantedTreesListAdapter(sampleDate)
        binding.ListRecyclerview.apply {
            adapter = listAdapter
        }
        binding.floatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addTreeFragment)
        }
    }
}