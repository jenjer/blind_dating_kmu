package com.example.myapplication.ui.hearts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class HeartsFragment : Fragment() {

    private lateinit var heartsViewModel: HeartsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        heartsViewModel =
                ViewModelProviders.of(this).get(HeartsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hearts, container, false)
        val textView: TextView = root.findViewById(R.id.text_hearts)
        heartsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}