package de.kozlowski.core.data.di

import de.kozlowski.core.data.repository.impl.NewsRepositoryImpl

/**
 * simple di provider
 */
object NewsCoreDiProvider {
    val newsRepository by lazy { NewsRepositoryImpl() }
}