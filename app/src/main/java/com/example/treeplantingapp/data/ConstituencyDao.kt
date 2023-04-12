package com.example.treeplantingapp.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ConstituencyDao {
    @Insert
    fun insertAll(constituencies: List<Constituency>)
}
