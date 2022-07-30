package com.animaluniverses.nytimes.data.data_classes

data class ResultResponse(
    var resultId : Int,
    var status: String,
    var copyright: String,
    var num_results: Int,
    var results: List<Article>
)