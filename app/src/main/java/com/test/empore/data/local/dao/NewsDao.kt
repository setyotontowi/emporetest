package com.test.empore.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.test.empore.data.model.News
import retrofit2.http.GET

@Dao
interface NewsDao {

    @get:Query("Select * From news where favorite = 1")
    val getFavorites: List<News>?

    @Query("Select * From news order by id desc")
    suspend fun getRecent(): List<News>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: News)

    @Delete
    suspend fun delete(news: News)

}