package com.rajit.hiltunittesting.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.rajit.hiltunittesting.R
import com.rajit.hiltunittesting.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getProducts()

        mainViewModel.products.observe(this) {
            if(it.data?.isNotEmpty() == true) {
                Toast.makeText(
                    applicationContext,
                    it.data.first().toString(),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Error Occurred",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}