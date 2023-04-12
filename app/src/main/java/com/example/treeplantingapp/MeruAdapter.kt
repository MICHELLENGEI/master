package com.example.treeplantingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treeplantingapp.databinding.MeruTreeItemBinding

class MeruAdapter (
    var meruList: ArrayList<Meru>,
) : RecyclerView.Adapter<MeruAdapter.MeruViewHolder>() {
    class MeruViewHolder(private val meru: MeruTreeItemBinding):RecyclerView.ViewHolder(meru.root){
        fun binding(currentMeruTreeItem: Meru){
            meru.idTextViewRecommend.text = currentMeruTreeItem.id.toString()
            meru.textViewTreeNameRecommend.text = currentMeruTreeItem.name
            meru.textViewTreeUsage.text = currentMeruTreeItem.uses
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeruViewHolder {
        return MeruViewHolder(MeruTreeItemBinding
            .inflate(LayoutInflater
                .from(parent.context),
            parent,false)
        )
    }

    override fun onBindViewHolder(holder: MeruViewHolder, position: Int) {
        holder.binding(meruList[position])
    }

    override fun getItemCount(): Int = meruList.size

}
