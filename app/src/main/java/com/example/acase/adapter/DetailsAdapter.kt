package com.example.acase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acase.databinding.HistoryBinding
import com.example.acase.model.ShoppingItems

class DetailsAdapter(private var items: List<ShoppingItems>) :
    RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    class ViewHolder(val binding: HistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.binding.itemName.text = items[position].itemName
        //holder.binding.itemAmount.text = items[position].itemAmount.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(newItems: List<ShoppingItems>) {
        items = newItems
        notifyDataSetChanged()
    }
}