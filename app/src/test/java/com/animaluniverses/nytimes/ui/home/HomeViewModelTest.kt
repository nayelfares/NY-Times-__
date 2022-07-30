package com.animaluniverses.nytimes.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.animaluniverses.nytimes.MainCoroutineRule
import com.animaluniverses.nytimes.data.api.FakeNewsApi
import com.animaluniverses.nytimes.data.repository.NewsRepo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module

@ExperimentalCoroutinesApi
 class HomeViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        startKoin{}
        val newsRepo = NewsRepo(FakeNewsApi())
        viewModel = HomeViewModel(newsRepo)
    }

    @Test
    fun `test fetch article response`() {
        viewModel.fetchArticlesList()

        val value = viewModel.articles.value

        assertThat(value?.size).isEqualTo(0)
    }
}