package com.example.password.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.password.R
import com.example.password.adapter.MyAdapter
import com.example.password.model.Note
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment(), MyAdapter.OnNoteSelected {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_home as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_home)

        val myDataset: Array<Note> = Array(9) { Note("Note$it", "", "ajakak@mai.ru", "", "") }
        val viewAdapter = MyAdapter(this)
        viewAdapter.notes = ArrayList(myDataset.asList())

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = viewAdapter
    }


    override fun onNoteSelected(position: Int) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.container, NoteFragment())
            ?.addToBackStack(null)
            ?.commit()
    }
}