package com.example.acase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


data class ShoppingItems(
    @ColumnInfo(name = "itemName")
    var itemName: String,
    @ColumnInfo(name = "itemAmount")
    var itemAmount: Int,
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}