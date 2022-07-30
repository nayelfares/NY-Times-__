package com.animaluniverses.nytimes.base

import android.app.Application
import com.animaluniverses.nytimes.modules.networkModule
import com.animaluniverses.nytimes.modules.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(
                networkModule,
                viewModelsModule
            ))
        }

    }

}