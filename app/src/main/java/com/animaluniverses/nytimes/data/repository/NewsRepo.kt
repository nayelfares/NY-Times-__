package com.animaluniverses.nytimes.data.repository

import com.animaluniverses.nytimes.data.api.NewsApi
import com.animaluniverses.nytimes.data.data_classes.ResultResponse

class NewsRepo(private val newsApi: NewsApi) {
    suspend fun fetchArticlesList(apiKey:String): ResultResponse = newsApi.fetchArticlesList(apiKey)
}