package com.example.instagram

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InstagramApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }

}