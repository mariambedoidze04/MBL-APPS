package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivityProductBinding

const val EXTRA_PRODUCT_PRICE = "com.example.androidcartapp.product_price"

class ActivityProduct : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productPrice = 120

        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(this, ActivityMyCart::class.java)

            intent.putExtra(EXTRA_PRODUCT_PRICE, productPrice)
            startActivity(intent)
        }
    }
}