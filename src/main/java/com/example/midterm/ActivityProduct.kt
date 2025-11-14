package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivityProductBinding

// Define a key for the data being passed (used in both Product and MyCart activities)
const val EXTRA_PRODUCT_PRICE = "com.example.androidcartapp.product_price"

class ActivityProduct : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // The base price is 120 (hardcoded as per assignment image)
        val productPrice = 120

        // Navigation: Product -> My Cart (Add to Cart, with data)
        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(this, ActivityMyCart::class.java)

            // CRITICAL: Pass the product price to the My Cart screen
            intent.putExtra(EXTRA_PRODUCT_PRICE, productPrice)
            startActivity(intent)
        }
    }
}