package com.animaluniverses.nytimes.modules

import com.animaluniverses.nytimes.ui.home.HomeViewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single { HomeViewModel(get()) }
}