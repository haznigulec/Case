package com.example.acase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acase.model.ShoppingItems

class ShoppingViewModel : ViewModel() {

    private val itemList = mutableListOf<ShoppingItems>()

    //val itemList = items.value?.toMutableList() ?: mutableListOf()
    val items = MutableLiveData<List<ShoppingItems>>()
    val firstError = MutableLiveData<Boolean>()



    fun datas() {

        val deneme = ShoppingItems("pelin", 5)
        val deneme2 = ShoppingItems("irem", 2)
        val deneme3 = ShoppingItems("hazni", 3)

        val itemlist = arrayListOf<ShoppingItems>(deneme, deneme2, deneme3)

        items.value = itemlist
        //  firstError.value=false
    }



    fun addItem(item: ShoppingItems) {
        val existingItem = itemList.find { it.itemName == item.itemName }
        if (existingItem == null) {
            itemList.add(item)
        } else {
            existingItem.itemAmount += item.itemAmount
        }
        items.value = itemList
    }

    fun updateItemAmount(itemName: String, newAmount: Int) {
        val existingItem = itemList.find { it.itemName == itemName }
        if (existingItem != null) {
            existingItem.itemAmount = newAmount
            if (existingItem.itemAmount <= 0) {
                itemList.remove(existingItem)
            }
            items.value = itemList
        }
    }

    fun removeItem(itemName: String) {
        val existingItem = itemList.find { it.itemName == itemName }
        if (existingItem != null) {
            itemList.remove(existingItem)
            items.value = itemList
        }
    }

    fun clearItems() {
        itemList.clear()
        items.value = itemList
    }
}
