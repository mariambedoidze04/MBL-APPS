package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivityMyCartBinding

class ActivityMyCart : AppCompatActivity() {

    private lateinit var binding: ActivityMyCartBinding
    private var productPrice: Int = 0 // Price of a single product (120$)
    private var quantity: Int = 1 // Initial quantity is 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. CRITICAL: Retrieve data (Price) from the Product Intent
        // Uses 'EXTRA_PRODUCT_PRICE' key defined in ActivityProduct.kt
        productPrice = intent.getIntExtra(EXTRA_PRODUCT_PRICE, 0)

        if (productPrice == 0) {
            // Handle case where no price was passed
            Toast.makeText(this, "Error: Product price not found. Defaulting to 120", Toast.LENGTH_LONG).show()
            productPrice = 120 // Fallback
        }

        // Initialize UI with initial values
        quantity = 2 // Based on the Figma screen image initial state
        binding.tvProductPrice.text = "${productPrice}$"
        updateUI()

        // Quantity Change: Increment
        binding.btnQuantityPlus.setOnClickListener {
            quantity++
            updateUI()
        }

        // Quantity Change: Decrement
        binding.btnQuantityMinus.setOnClickListener {
            // CRITICAL: Quantity must not drop below 1
            if (quantity > 1) {
                quantity--
                updateUI()
            } else {
                Toast.makeText(this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigation: My Cart -> Payment Successful (Place Order)
        binding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, ActivitySuccess::class.java)
            startActivity(intent)
        }

        // Navigation: My Cart -> Product (Back Navigation)
        binding.ivBackArrow.setOnClickListener {
            // Back Navigation using finish()
            finish()
        }
    }

    /**
     * Recalculates the total price and updates the quantity and total TextViews.
     */
    private fun updateUI() {
        val newTotal = productPrice * quantity

        // Update Quantity Display
        binding.tvQuantity.text = quantity.toString()

        // Update Subtotal (showing the calculated quantity)
        binding.tvSubtotalLabel.text = "Subtotal ($quantity items)"

        // Update Total Price Display (Example: 120 * 3 = 360$)
        binding.tvTotalAmount.text = "${newTotal} $"
    }
}