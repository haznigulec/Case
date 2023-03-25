package com.example.acase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acase.model.ShoppingItems

class ShoppingViewModel : ViewModel() {


    val items = MutableLiveData<List<ShoppingItems>>()
    val firstError = MutableLiveData<Boolean>()

    fun addItem(item: ShoppingItems) {
        val itemList = items.value?.toMutableList() ?: mutableListOf()
        val existingItem = itemList.find { it.itemName == item.itemName }

        if (existingItem == null) {
            itemList.add(item)
        } else {
            existingItem.itemAmount += item.itemAmount
        }

        items.value = itemList
    }


    fun datas(){

        val deneme = ShoppingItems("pelin",5)
        val deneme2 = ShoppingItems("irem",2)
        val deneme3 = ShoppingItems("hazni",3)

        val itemlist = arrayListOf<ShoppingItems>(deneme,deneme2,deneme3)

        items.value= itemlist
       //  firstError.value=false
    }
    fun clearItems() {
        items.value = emptyList()
    }
}