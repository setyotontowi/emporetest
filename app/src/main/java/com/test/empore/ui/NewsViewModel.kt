package com.test.empore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.empore.data.local.repository.LocalRepository
import com.test.empore.data.model.News
import com.test.empore.data.model.Result
import com.test.empore.data.remote.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val localRepository: LocalRepository
): ViewModel() {

    private val _news = MutableLiveData<Result<News>>()
    val news :LiveData<Result<News>> = _news

    private val _localNews = MutableLiveData<List<News>>()
    val localNews: LiveData<List<News>> = _localNews

    fun get(endPoints: String, country: String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = newsRepository.get(endPoints, country)
            _news.postValue(result)
        }
    }

    fun search(q: String, page:String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = newsRepository.search(q, page)
            _news.postValue(result)
        }
    }

    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = localRepository.getFavorite()
            _localNews.postValue(result)
        }
    }

    fun getRecent(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = localRepository.getRecent()
            _localNews.postValue(result)
        }
    }

    fun insert(news: News, callback: ((id:Long) -> Unit)?){
        viewModelScope.launch {
            val id = localRepository.insert(news)
            callback?.invoke(id)
        }
    }

    fun update(news: News){
        viewModelScope.launch {
            localRepository.update(news)
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            localRepository.deleteAll()
        }
    }

}