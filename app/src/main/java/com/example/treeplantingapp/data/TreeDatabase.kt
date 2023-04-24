package com.example.treeplantingapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Tree::class ],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class TreeDatabase : RoomDatabase() {

    abstract fun treeDao(): TreeDao

    companion object{

        private var INSTANCE : TreeDatabase? =null

        fun getDatabase(context: Context): TreeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TreeDatabase::class.java,
                    "tree_planted_data_table"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }

}
