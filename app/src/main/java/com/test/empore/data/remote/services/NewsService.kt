package com.test.empore.data.remote.services

import com.test.empore.data.model.News
import com.test.empore.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("{endpoints}")
    suspend fun getNews(
        @Path("endpoints") endPoints: String,
        @Query("country") country:String
    ): Result<News>

    @GET("everything")
    suspend fun search(
        @Query("q") q:String,
        @Query("page") page:String
    ): Result<News>

}