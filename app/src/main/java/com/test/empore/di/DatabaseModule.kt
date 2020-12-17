package com.test.empore.di

import android.content.Context
import androidx.room.Room
import com.test.empore.data.local.AppDatabase
import com.test.empore.data.local.dao.NewsDao
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    private const val DATABASE_NAME = "database"

    @Provides
    fun providesDatabase(appContext: Context): AppDatabase{
        return Room
            .databaseBuilder(appContext.applicationContext, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesNewsDao(db: AppDatabase): NewsDao = db.newsDao()
}