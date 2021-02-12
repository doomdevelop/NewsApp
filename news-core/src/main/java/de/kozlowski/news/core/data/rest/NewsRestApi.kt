package de.kozlowski.news.core.data.rest

import kotlinx.coroutines.flow.Flow

interface NewsRestApi {
    suspend fun getNews():Flow<NewsRestData>
}