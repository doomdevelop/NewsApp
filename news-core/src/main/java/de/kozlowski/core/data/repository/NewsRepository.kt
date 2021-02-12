package de.kozlowski.core.data.repository

import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews():Flow<List<NewsCore>>
}