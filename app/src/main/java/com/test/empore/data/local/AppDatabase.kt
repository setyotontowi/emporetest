package com.test.empore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.test.empore.data.local.dao.NewsDao
import com.test.empore.data.model.News
import javax.inject.Singleton

@Singleton
@Database(entities = [News::class], version = 4)
@TypeConverters(Converter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}