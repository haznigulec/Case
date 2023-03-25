package com.example.acase.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.acase.model.ShoppingItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val itemList = mutableListOf<ShoppingItems>()
    private val SHARED_PREFS_KEY = "MyPrefs"
    //val itemList = items.value?.toMutableList() ?: mutableListOf()
    val items = MutableLiveData<List<ShoppingItems>>()
    val firstError = MutableLiveData<Boolean>()

    private val sharedPreferences = application.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

    fun loadData() {
        val gson = Gson()
        val json = sharedPreferences.getString("itemList", "")
        if (json != "") {
            val type = object : TypeToken<List<ShoppingItems>>() {}.type
            itemList.clear()
            itemList.addAll(gson.fromJson(json, type))
            items.value = itemList
        }
    }

    fun saveData() {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(itemList)
        editor.putString("itemList", json)
        editor.apply()
    }

    fun datas() {

        /*val deneme = ShoppingItems("pelin", 5)
        val deneme2 = ShoppingItems("irem", 2)
        val deneme3 = ShoppingItems("hazni", 3)

        val itemlist = arrayListOf<ShoppingItems>(deneme, deneme2, deneme3) */


        //itemList.clear()
        //items.value = emptyList()
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
        items.value = emptyList()

    }


}
