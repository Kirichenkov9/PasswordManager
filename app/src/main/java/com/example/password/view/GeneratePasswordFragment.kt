package com.example.password.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

class GeneratePasswordFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LOL", "genOnAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LOL", "genOnViewCreated")
    }
}