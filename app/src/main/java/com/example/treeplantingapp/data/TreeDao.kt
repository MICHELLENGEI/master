package com.example.treeplantingapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface TreeDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTree(tree:Tree)

    @Query("SELECT * FROM trees_planted_data_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Tree>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(tree: Tree)
}
