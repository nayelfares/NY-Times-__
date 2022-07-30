package com.animaluniverses.nytimes.data.api

import com.animaluniverses.nytimes.data.data_classes.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("all-sections/7.json")
    suspend fun fetchArticlesList(@Query("api-key") apiKey: String): ResultResponse
}