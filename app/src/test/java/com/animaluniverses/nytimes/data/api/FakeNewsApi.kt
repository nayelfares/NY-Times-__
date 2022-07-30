package com.animaluniverses.nytimes.data.api

import com.animaluniverses.nytimes.data.data_classes.ResultResponse

class FakeNewsApi:NewsApi {
    override suspend fun fetchArticlesList(apiKey: String): ResultResponse {
        return ResultResponse(1,"","", 1,listOf())
    }
}