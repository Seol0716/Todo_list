package com.example.todo_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo_project.databinding.CalendarBinding

class Calendar: Fragment(R.layout.calendar) {

    //fragment
    private var _binding: CalendarBinding?= null

    //view
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CalendarBinding.inflate(inflater,container,false)
        val view = binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}