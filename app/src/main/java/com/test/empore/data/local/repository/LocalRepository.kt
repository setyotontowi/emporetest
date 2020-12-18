package com.test.empore.data.local.repository

import com.test.empore.data.local.dao.NewsDao
import com.test.empore.data.model.News
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val newsDao: NewsDao
) {

    fun getFavorite() = newsDao.getFavorites

    suspend fun getRecent() = newsDao.getRecent()

    suspend fun insert(news: News): Long = newsDao.insert(news)

    suspend fun update(news: News) = newsDao.update(news)

    suspend fun deleteAll() = newsDao.deleteAll()
}