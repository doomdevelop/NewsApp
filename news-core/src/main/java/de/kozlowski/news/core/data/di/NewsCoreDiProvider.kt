package de.kozlowski.news.core.data.di

import de.kozlowski.news.core.data.repository.impl.NewsRepositoryImpl

/**
 * simple di provider
 */
object NewsCoreDiProvider {
    val newsRepository by lazy { NewsRepositoryImpl() }
}