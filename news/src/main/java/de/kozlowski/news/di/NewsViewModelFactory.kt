package de.kozlowski.news.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.kozlowski.news.NewsViewModel
import de.kozlowski.news.core.data.repository.NewsRepository

internal class NewsViewModelFactory(private val newsRepository:NewsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}