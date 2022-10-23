package com.example.galleryapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "MyApp"

@HiltAndroidApp
class MyApp : Application()