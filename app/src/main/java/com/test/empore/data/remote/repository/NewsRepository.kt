package com.test.empore.data.remote.repository

import com.test.empore.data.model.News
import com.test.empore.data.model.Result
import com.test.empore.data.remote.services.NewsService
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService
) {

    suspend fun get(endPoint:String, country: String): Result<News>{
        return newsService.getNews(endPoint, country)
    }
}