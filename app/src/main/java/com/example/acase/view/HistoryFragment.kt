package com.example.acase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acase.adapter.HistoryAdapter
import com.example.acase.databinding.FragmentHistoryBinding
import com.example.acase.viewmodel.ShoppingViewModel


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var viewModel: ShoppingViewModel
    private lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        viewModel.loadData()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        adapter = HistoryAdapter(emptyList())
        binding.rcview.layoutManager = LinearLayoutManager(requireContext())
        binding.rcview.adapter = adapter




    }
}

