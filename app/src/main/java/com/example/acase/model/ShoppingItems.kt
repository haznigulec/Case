package com.example.acase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItems(
    @ColumnInfo(name = "item_name")
    val itemName : String,
    @ColumnInfo(name = "item_amount")
    var itemAmount : Int) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
