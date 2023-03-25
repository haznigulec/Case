package com.example.acase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.acase.R
import com.example.acase.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding : FragmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHistoryBinding.inflate(inflater,container,false)
        return binding.root

    }


}