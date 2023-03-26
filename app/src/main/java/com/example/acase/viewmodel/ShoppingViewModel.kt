package com.example.acase.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.acase.model.HistoryList
import com.example.acase.model.ShoppingItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val itemList = mutableListOf<HistoryList>()

    val items = MutableLiveData<List<ShoppingItems>>()
    val firstError = MutableLiveData<Boolean>()
    private val sharedPreferences = application.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)



     fun loadData() {

         val gson = Gson()

         val json = sharedPreferences.getString("itemList", "")

         if (json != "") {

             val type = object : TypeToken<List<HistoryList>>() {}.type

             itemList.clear()

           itemList.addAll(gson.fromJson(json, type))
             println(itemList)
          items.value = itemList.last().itemList
}

}

     fun saveData() {
      //   if(itemList!=null){
         val editor = sharedPreferences.edit()
         val gson = Gson()
         val json = gson.toJson(itemList)
         editor.putString("itemList", json)
         editor.apply()

     }

    fun addItem(item: ShoppingItems) {
        if(itemList.last().itemList != null){

            val existingItem = itemList.last().itemList.find { it.itemName == item.itemName }
            if (existingItem == null) {
                itemList.last().itemList.add(item)
            } else {
                existingItem.itemAmount += item.itemAmount
            }
        }else {
            val list = mutableListOf<ShoppingItems>()
            list.add(item)
            itemList.add(HistoryList("isim",list))
        }

        items.value = itemList.last().itemList
    }

    fun updateItemAmount(itemName: String, newAmount: Int) {
        val existingItem = itemList.last().itemList.find { it.itemName == itemName }
        if (existingItem != null) {
            existingItem.itemAmount = newAmount
            if (existingItem.itemAmount <= 0) {
                itemList.last().itemList.remove(existingItem)
            }
            items.value = itemList.last().itemList
        }
    }

    fun removeItem(itemName: String) {
        val existingItem = itemList.last().itemList.find { it.itemName == itemName }
        if (existingItem != null) {
            itemList.last().itemList.remove(existingItem)
            items.value = itemList.last().itemList
        }
    }

    fun clearItems() {
        itemList.clear()
        items.value = emptyList()

    }


}
