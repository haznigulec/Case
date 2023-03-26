package com.example.acase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class HistoryList(
    @ColumnInfo(name = "itemName")
    var displayName: String,
    @ColumnInfo(name = "itemList")
    var itemList: MutableList<ShoppingItems>

){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}