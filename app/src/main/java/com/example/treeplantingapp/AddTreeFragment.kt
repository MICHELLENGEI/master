package com.example.treeplantingapp

//import kotlinx.android.synthetic.main.fragment_add_tree.*
//import kotlinx.android.synthetic.main.fragment_add_tree.view.*
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.treeplantingapp.data.Tree
import com.example.treeplantingapp.data.TreeDatabase
import com.example.treeplantingapp.databinding.FragmentAddTreeBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTreeFragment : Fragment() {
    private lateinit var binding: FragmentAddTreeBinding
    private lateinit var treeDatabase: TreeDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddTreeBinding.inflate(layoutInflater)
        treeDatabase = TreeDatabase.getDatabase(requireContext())

        binding.addTree.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun insertDataToDatabase() {

        val treeName = binding.editTextTreeName.text.toString()
        val treeLocation = binding.editTextTreeLocation.text.toString()
        val treeNumber = binding.editTextNumber0fTrees.text

        if (inputCheck(treeName, treeLocation, treeNumber)) {
            //tree object
            val tree = Tree(
                treeName = treeName,
                treeLocation = treeLocation,
                treeNumber = Integer.parseInt(treeNumber.toString())
            )
            //add data to database
            GlobalScope.launch(Dispatchers.IO) {
                treeDatabase.treeDao().insert(tree)
            }
            Toast.makeText(requireContext(), "Tree added Successfully", Toast.LENGTH_LONG).show()
            //Navigate back
            val navController = findNavController()
            navController.navigate(R.id.action_addTreeFragment_to_homeFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(treeName: String, treeLocation: String, treeNumber: Editable): Boolean {
        return !(TextUtils.isEmpty(treeName) && TextUtils.isEmpty(treeLocation) && treeNumber.isEmpty())
    }


}
