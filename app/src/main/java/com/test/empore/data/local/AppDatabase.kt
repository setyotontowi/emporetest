package com.test.empore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.empore.data.local.dao.NewsDao
import com.test.empore.data.model.News
import javax.inject.Singleton

@Singleton
@Database(entities = [News::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}