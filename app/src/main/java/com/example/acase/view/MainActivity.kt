package com.example.acase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.acase.R
import com.example.acase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}