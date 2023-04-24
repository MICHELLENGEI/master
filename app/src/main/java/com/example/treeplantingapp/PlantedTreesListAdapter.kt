package com.example.treeplantingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treeplantingapp.data.Tree
import com.example.treeplantingapp.databinding.CustomRowBinding

class PlantedTreesListAdapter(
    var treeList: List<Tree>,
) : RecyclerView.Adapter<PlantedTreesListAdapter.MyViewHolder>() {

    class MyViewHolder(private val tree: CustomRowBinding) : RecyclerView.ViewHolder(tree.root) {
        fun bind(currentTree: Tree) {
            tree.idTextView.text = currentTree.id.toString()
            tree.textViewTreeName.text = currentTree.treeName
            tree.textViewTreeLocation.text = currentTree.treeLocation
            tree.textViewTreeNumber.text = currentTree.treeNumber.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CustomRowBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = treeList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return treeList.size
    }

    fun setData(tree: List<Tree>) {
        this.treeList = tree as ArrayList<Tree>
        notifyDataSetChanged()


    }
}
