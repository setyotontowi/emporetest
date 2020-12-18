package com.test.empore.di

import android.util.Log
import com.test.empore.data.remote.services.NewsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    private const val BASE_URL = "https://newsapi.org/v2/"
    private const val API_KEY = "0fc6eff3e5024cb8b1c731aa67bfb920"

    @Provides
    fun provideNewsRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build()

    @Provides
    fun provideNewsService(retrofit: Retrofit) : NewsService = retrofit.create(NewsService::class.java)

    private fun client(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor {
            val request: Request = it.request().newBuilder().addHeader("X-Api-Key", API_KEY).build()
            it.proceed(request)
        }
        return client.build()
    }



}