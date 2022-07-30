package com.animaluniverses.nytimes.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.animaluniverses.nytimes.BuildConfig
import com.animaluniverses.nytimes.base.BaseViewModel
import com.animaluniverses.nytimes.data.data_classes.Article
import com.animaluniverses.nytimes.data.repository.NewsRepo

class HomeViewModel(private val newsRepo: NewsRepo) : BaseViewModel()  {

    private val _articles = MutableLiveData<List<Article>>()
    val articles : LiveData<List<Article>> = _articles

    private val _loading = MutableLiveData(false)
    val loading : LiveData<Boolean> = _loading

    fun fetchArticlesList(){
        _loading.postValue(true)
        launch({ newsRepo.fetchArticlesList(BuildConfig.API_KEY) }, {
            _articles.postValue(it.results)
            _loading.postValue(false)
        }) {
            _loading.postValue(false)
        }
    }
}