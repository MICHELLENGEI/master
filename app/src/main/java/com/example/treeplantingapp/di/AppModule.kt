package com.example.treeplantingapp.di

import android.app.Application
import androidx.room.Room
import com.example.treeplantingapp.data.StartingTrees
import com.example.treeplantingapp.data.TreeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun providesTreePlantingDatabase(application: Application): TreeDatabase{
        return Room.databaseBuilder(
            application.applicationContext,
            TreeDatabase::class.java,
            "trees_database"
        ).fallbackToDestructiveMigration()
            .addCallback(callback = StartingTrees(application.applicationContext))
            .build()
    }
}
