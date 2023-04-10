package com.example.appanalytics.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appanalytics.databinding.ItemNoteBinding
import com.example.appanalytics.Listener.OnClickNote
import com.example.appanalytics.Model.Note

class AdapterNote(
     var contactList: ArrayList<Note>,
     val listener: OnClickNote
) : RecyclerView.Adapter<AdapterNote.MyViewHolder>() {

    class MyViewHolder( val itemBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(note: Note) {
            itemBinding.titleNote.text = note.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = contactList[position]
        holder.bind(note)
        holder.itemView.setOnClickListener {
            listener.onClick(note)
        }
    }
}