package com.example.password.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.password.R
import com.example.password.showToast
import kotlinx.android.synthetic.main.fragment_create_password.*

class CreatePasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar_add.title = getString(R.string.title_create)


        toolbar_add.menu.findItem(R.id.action_create).setOnMenuItemClickListener {
            if (checkFields()) {
                showToast(requireContext(), getString(R.string.empty_field))
            }
            return@setOnMenuItemClickListener true
        }
    }

    private fun checkFields(): Boolean =
        title_edt.text.isNullOrBlank() || username_edt.text.isNullOrBlank() || password_edt.text.isNullOrBlank()
}