package com.example.treeplantingapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Tree::class, Plant::class], version = 1, exportSchema = true)
abstract class TreeDatabase : RoomDatabase() {

    abstract fun treeDao(): TreeDao
    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile
        private var INSTANCE: TreeDatabase? = null


        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): TreeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TreeDatabase::class.java,
                    "trees_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}