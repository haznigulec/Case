package com.example.acase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acase.databinding.ItemsBinding
import com.example.acase.model.ShoppingItems
import com.example.acase.viewmodel.ShoppingViewModel

class ShoppingAdapter(private val ShoppingItem: ArrayList<ShoppingItems>, private val viewModel: ShoppingViewModel)  :
    RecyclerView.Adapter<ShoppingAdapter.ViewHolder>(){

    class ViewHolder(private val binding : ItemsBinding, private val viewModel: ShoppingViewModel) : RecyclerView.ViewHolder(binding.root){

        fun bind (things: ShoppingItems){
            binding.textList.text=things.itemName
            binding.textAmount.text = "${things.itemAmount}"

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,viewModel)
    }

    override fun getItemCount(): Int {

        return  ShoppingItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ShoppingItem[position])
    }



    fun updateList(newItemList:List<ShoppingItems>){
        ShoppingItem.clear()
        ShoppingItem.addAll(newItemList)
        notifyDataSetChanged()

    }
    fun clearItems() {
        ShoppingItem.clear()
        notifyDataSetChanged()
    }

}

