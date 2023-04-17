package com.example.treeplantingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treeplantingapp.databinding.MeruTreeItemBinding

class CountyTreeAdapter(
    var meruList: ArrayList<CountyTree>,
) : RecyclerView.Adapter<CountyTreeAdapter.MeruViewHolder>() {
    class MeruViewHolder(private val meru: MeruTreeItemBinding) :
        RecyclerView.ViewHolder(meru.root) {
        fun binding(currentCountyTree: CountyTree) {
            meru.idTextViewRecommend.text = currentCountyTree.id.toString()
            meru.textViewTreeNameRecommend.text = currentCountyTree.name
            meru.textViewTreeUsage.text = currentCountyTree.uses
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeruViewHolder {
        return MeruViewHolder(MeruTreeItemBinding
            .inflate(LayoutInflater
                .from(parent.context),
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: MeruViewHolder, position: Int) {
        holder.binding(meruList[position])
    }

    override fun getItemCount(): Int = meruList.size

}
