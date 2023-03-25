package com.example.acase.service

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.acase.model.ShoppingItems

@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(items: ShoppingItems)

    @Delete
    suspend fun delete(items: ShoppingItems)

    @Query("SELECT * FROM shopping_items")
    fun getShoppingItems(): LiveData<List<ShoppingItems>>
}