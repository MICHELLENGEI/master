package com.example.treeplantingapp

import androidx.lifecycle.ViewModel

class MeruViewModel:ViewModel() {
    val meruList = MeruuRepository().getMeruData()
}