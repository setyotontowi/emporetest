package com.test.empore.data.local.repository

import com.test.empore.data.local.dao.NewsDao
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    newsDao: NewsDao
) {
}