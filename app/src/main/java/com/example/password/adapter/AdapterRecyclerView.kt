package com.example.password.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.password.R
import com.example.password.model.Note
import kotlinx.android.synthetic.main.list_item_view.view.*


class MyAdapter(private val listener: OnNoteSelected) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var notes: ArrayList<Note> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(notes[position], listener)
    }

    override fun getItemCount() = notes.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var listener: OnNoteSelected

        fun bind(note: Note, listener: OnNoteSelected) {
            itemView.title_item.text = note.title
            itemView.username_item.text = note.username

            this.listener = listener
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onNoteSelected(adapterPosition)
        }
    }

    interface OnNoteSelected {
        fun onNoteSelected(position: Int)
    }
}
