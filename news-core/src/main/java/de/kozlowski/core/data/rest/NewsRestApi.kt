package de.kozlowski.core.data.rest

import kotlinx.coroutines.flow.Flow

interface NewsRestApi {
    suspend fun getNews():Flow<NewsRestData>
}