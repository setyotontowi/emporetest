package com.test.empore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.empore.data.local.repository.FavoriteRepository
import com.test.empore.data.model.News
import com.test.empore.data.model.Result
import com.test.empore.data.remote.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val favoriteRepository: FavoriteRepository
): ViewModel() {

    private val _news = MutableLiveData<Result<News>>()
    val news :LiveData<Result<News>> = _news

    fun get(endPoints: String, country: String){
        viewModelScope.launch {
            val result = newsRepository.get(endPoints, country)
            _news.postValue(result)
        }
    }

    fun insert(news: News){
        viewModelScope.launch {
            favoriteRepository.insert(news)
        }
    }

}