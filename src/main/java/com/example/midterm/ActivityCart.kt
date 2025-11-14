package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivityCartBinding

class ActivityCart : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartShopping.setOnClickListener {
            val intent = Intent(this, ActivityProduct::class.java)
            startActivity(intent)
        }
    }
}