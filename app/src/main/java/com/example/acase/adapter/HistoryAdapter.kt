package com.example.acase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acase.databinding.NumberBinding
import com.example.acase.model.HistoryList

class HistoryAdapter(private var numbers: List<HistoryList>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(val binding:NumberBinding ) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            NumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.number.text = "List ${numbers[position].displayName}"
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

}