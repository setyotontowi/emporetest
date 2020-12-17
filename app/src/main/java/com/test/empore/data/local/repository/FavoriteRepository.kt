package com.test.empore.data.local.repository

import com.test.empore.data.local.dao.NewsDao
import com.test.empore.data.model.News
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend fun insert(news: News) = newsDao.insert(news)
}