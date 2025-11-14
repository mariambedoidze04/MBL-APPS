package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivityMyCartBinding

class ActivityMyCart : AppCompatActivity() {

    private lateinit var binding: ActivityMyCartBinding
    private var productPrice: Int = 0
    private var quantity: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productPrice = intent.getIntExtra(EXTRA_PRODUCT_PRICE, 0)

        if (productPrice == 0) {
            Toast.makeText(this, "Error: Product price not found. Defaulting to 120", Toast.LENGTH_LONG).show()
            productPrice = 120 // Fallback
        }

        quantity = 2
        binding.tvProductPrice.text = "${productPrice}$"
        updateUI()

        binding.btnQuantityPlus.setOnClickListener {
            quantity++
            updateUI()
        }

        binding.btnQuantityMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateUI()
            } else {
                Toast.makeText(this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, ActivitySuccess::class.java)
            startActivity(intent)
        }

        binding.ivBackArrow.setOnClickListener {
            finish()
        }
    }

    private fun updateUI() {
        val newTotal = productPrice * quantity

        binding.tvQuantity.text = quantity.toString()

        binding.tvSubtotalLabel.text = "Subtotal ($quantity items)"

        binding.tvTotalAmount.text = "${newTotal} $"
    }
}