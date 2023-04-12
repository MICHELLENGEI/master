package com.example.treeplantingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trees_planted_data_table")
data class Tree(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    val treeName: String?,
    val treeLocation: String?,
    val treeNumber: Int?,
)

