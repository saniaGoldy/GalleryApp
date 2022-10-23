package com.example.galleryapp.ui.mainActivity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.galleryapp.TAG
import com.example.galleryapp.databinding.ActivityMainBinding
import com.example.galleryapp.domain.services.ConnectivityObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNetworkObserver()

    }

    private fun setupNetworkObserver() {
        viewModel.networkStatus.observe(this) { status ->
            Log.d(TAG, "ConnectivityStatus: $status")

            binding.noInternetConnectionTV.isVisible =
                status != ConnectivityObserver.Status.Available
        }
    }
}