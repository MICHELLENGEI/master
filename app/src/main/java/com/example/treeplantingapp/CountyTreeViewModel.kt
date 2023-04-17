package com.example.treeplantingapp

import androidx.lifecycle.ViewModel

class CountyTreeViewModel : ViewModel() {
    fun getDisplayList(code: Int): ArrayList<CountyTree> {
        return when (code) {
            1 -> CountyTreeRepository.getMeruData()
            2 -> CountyTreeRepository.getTaitaData()
            3 -> CountyTreeRepository.getBaringoData()
            4 -> CountyTreeRepository.getKituiData()
            else -> {
                arrayListOf<CountyTree>()
            }
        }
    }
}
