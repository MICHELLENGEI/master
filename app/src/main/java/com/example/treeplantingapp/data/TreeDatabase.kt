package com.example.treeplantingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Tree::class, Constituency::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class TreeDatabase : RoomDatabase() {

    abstract val treeDao: TreeDao
    abstract val constituencyDao: ConstituencyDao
}
