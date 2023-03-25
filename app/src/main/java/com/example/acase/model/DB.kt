package com.example.acase.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.acase.service.DAO

@Database(entities = [ShoppingItems::class],
    version = 1)
abstract class DB : RoomDatabase() {

    abstract fun getShoppingDao() : DAO

    companion object {

        @Volatile
        private var instance: DB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {

            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, DB::class.java, "DB.db").build()

    }
}
