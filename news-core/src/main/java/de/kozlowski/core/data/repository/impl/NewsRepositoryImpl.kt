package de.kozlowski.core.data.repository.impl

import de.kozlowski.core.data.repository.NewsCore
import de.kozlowski.core.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

//TODO: provide via constructor instances of data sources ( de.kozlowski.core.data.rest.NewsRestApi , de.kozlowski.core.data.dao.NewsDao )
class NewsRepositoryImpl : NewsRepository {
    
    override suspend fun getNews(): Flow<List<NewsCore>> =
        //TODO: fetch data from data sources
        flowOf(mutableListOf<NewsCore>().apply {
            for (i in 0..10) {
                add(NewsCore("header $i", "text of item $i"))
            }
        })
}