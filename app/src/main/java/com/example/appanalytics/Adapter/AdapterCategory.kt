package com.example.appanalytics.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appanalytics.databinding.ItemCategoryBinding
import com.example.appanalytics.Listener.OnClickCategory
import com.example.appanalytics.Model.Categories

class AdapterCategory(
     var contactList: ArrayList<Categories>,
     val listener: OnClickCategory) : RecyclerView.Adapter<AdapterCategory.MyViewHolder>() {

    class MyViewHolder(private val itemBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: Categories) {
            itemBinding.nameCategory.text = category.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
             return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = contactList[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            listener.onClick(category.name!!)
        }
    }
}