package com.test.empore.data.local.repository

import com.test.empore.data.local.dao.NewsDao
import com.test.empore.data.model.News
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend fun insert(news: News) = newsDao.insert(news)

    fun getFavorite() = newsDao.getFavorites

    suspend fun getRecent() = newsDao.getRecent()
}