package com.example.treeplantingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "constituency_table")
data class Constituency(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val wards: List<String>
)

/**
 * Paste the json file in a `raw` directory
 * Load json file content when creating the database instance
 * If Room doesn't know how to save List<String>, Add type converter for it
 *
 *
**/