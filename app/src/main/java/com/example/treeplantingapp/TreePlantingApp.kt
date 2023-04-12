package com.example.treeplantingapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TreePlantingApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}