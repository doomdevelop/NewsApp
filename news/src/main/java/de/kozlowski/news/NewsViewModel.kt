package de.kozlowski.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.kozlowski.core.data.repository.NewsRepository
import de.kozlowski.news.model.NewsItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

internal class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    //display or hide progress loader
    private val _showProgressLiveData = MutableLiveData<Boolean>()
    val showProgressLiveData: LiveData<Boolean> = _showProgressLiveData

    //data
    private val _newsLiveData = MutableLiveData<List<NewsItem>>()
    val newsLiveData: LiveData<List<NewsItem>> = _newsLiveData

    init {
        _showProgressLiveData.value = true
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {

            try {
                newsRepository.getNews().collect { newsCoreList ->
                    newsCoreList.map { NewsItem(it.headerText, it.text) }.also {  result->
                        _newsLiveData.postValue(result )
                    }

                }
            } catch (e: Exception) {
                Timber.e(e,"Could not fetch news data")
                //todo : provide error to the view
            } finally {
                _showProgressLiveData.postValue(false)
            }
        }
    }

    fun onSwipeRefresh() {
        fetchData()
    }
}