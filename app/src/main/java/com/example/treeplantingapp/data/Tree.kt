package com.example.treeplantingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trees_planted_data_table")
data class Tree (
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "tree_name")val treeName: String?,
    @ColumnInfo(name = "tree_location")val treeLocation: String?,
    @ColumnInfo(name = "tree_numbers")val treeNumber: Int?
)

