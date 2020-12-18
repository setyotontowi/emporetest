package com.test.empore.data.remote.repository

import android.util.Log
import com.test.empore.data.model.News
import com.test.empore.data.model.Result
import com.test.empore.data.remote.services.NewsService
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService
) {

    suspend fun get(endPoint:String, country: String): Result<News>{
        return try {
            return newsService.getNews(endPoint, country)
        } catch (e: HttpException){
            Log.e("NewsRepository", "search: ", e)
            val result: Result<News> = Result("failed", 0, ArrayList())
            result
        }
    }

    suspend fun search(q: String, page:String): Result<News> {
        return try {
            newsService.search(q, page)
        } catch (e: HttpException){
            Log.e("NewsRepository", "search: ", e)
            val result: Result<News> = Result("failed", 0, ArrayList())
            result
        }
    }

}