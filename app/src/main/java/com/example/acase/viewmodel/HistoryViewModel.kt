package com.example.acase.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.acase.model.HistoryList
import com.example.acase.model.ShoppingItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    val itemList = mutableListOf<HistoryList>()

    val items = MutableLiveData<List<HistoryList>>()
    val firstError = MutableLiveData<Boolean>()
    private val sharedPreferences = application.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)



    fun loadData() {

        val gson = Gson()

        val json = sharedPreferences.getString("itemList", "")

        if (json != "") {

            val type = object : TypeToken<List<HistoryList>>() {}.type

            itemList.clear()

            itemList.addAll(gson.fromJson(json, type))
            items.value = itemList
        }

    }

}