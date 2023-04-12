package com.example.treeplantingapp

//import kotlinx.android.synthetic.main.fragment_add_tree.*
//import kotlinx.android.synthetic.main.fragment_add_tree.view.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.treeplantingapp.data.TreeViewModel
import com.example.treeplantingapp.databinding.FragmentAddTreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTreeFragment : Fragment() {
    private lateinit var binding: FragmentAddTreeBinding
    private val viewModel: TreeViewModel by activityViewModels<TreeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentAddTreeBinding.inflate(layoutInflater)

        binding.addTree.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.homeFragment)
           // insertDataToDatabase()
        }
        return binding.root
    }}
    /*private fun insertDataToDatabase() {

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
            viewModel.addTree(tree)
            Toast.makeText(requireContext(), "Tree added Successfully", Toast.LENGTH_LONG).show()
            //Navigate back
            val navController = findNavController()
            //navController.navigate(R.id.homeFragment)
            navController.popBackStack()
        } else {
            Toast.makeText(requireContext(), "Fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(
        treeName: String,
        treeLocation: String,
        treeNumber: Editable): Boolean {
        return !(TextUtils.isEmpty(treeName)
                && TextUtils.isEmpty(treeLocation)
                && treeNumber.isEmpty())
    }


}
*/
