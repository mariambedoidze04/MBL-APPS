package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcartapp.databinding.ActivitySuccessBinding

class ActivitySuccess : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigation: Done button goes back to the main Cart screen
        binding.btnDone.setOnClickListener {
            val intent = Intent(this, ActivityCart::class.java).apply {
                // Clear the back stack so the user cannot navigate back to the success or cart screens
                // This is good practice for post-transaction screens
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
        }
    }
}