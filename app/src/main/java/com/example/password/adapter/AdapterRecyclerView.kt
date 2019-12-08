package com.example.password.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.password.R
import com.example.password.model.Note
import kotlinx.android.synthetic.main.list_item_view.view.*


class MyAdapter(private val notes: Array<Note>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = notes[position].title
        holder.userName.text = notes[position].username
    }

    override fun getItemCount() = notes.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.title_item
        val userName: TextView = itemView.username_item
    }
}
