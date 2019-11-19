package com.example.password.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.password.R
import com.example.password.adapter.MyAdapter

class HomeFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LOL", "homedOnAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset: Array<String> = Array(11) { "$it" }
        val viewManager = LinearLayoutManager(context)
        val viewAdapter = MyAdapter(myDataset)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = viewAdapter


        Toast.makeText(context, viewAdapter.itemCount.toString(), Toast.LENGTH_LONG).show()

    }
}