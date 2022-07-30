package com.animaluniverses.nytimes.modules

import com.animaluniverses.nytimes.BuildConfig
import com.animaluniverses.nytimes.data.api.NewsApi
import com.animaluniverses.nytimes.data.repository.NewsRepo
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideInterceptor() }
    single { provideDefaultOkhttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideNewsApi(get()) }
    single { NewsRepo(get()) }
    single { Gson() }
}

fun provideDefaultOkhttpClient(interceptors: ArrayList<Interceptor>): OkHttpClient {
    val client =  OkHttpClient.Builder()
        for (interceptor in interceptors)
            client.addInterceptor(interceptor)
    return client.build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideNewsApi(retrofit: Retrofit): NewsApi {
    return retrofit.create(NewsApi::class.java)
}


fun provideNewsRepo(newsApi: NewsApi): NewsRepo {
    return NewsRepo(newsApi)
}



fun provideInterceptor() : ArrayList<Interceptor>{
        val interceptors = arrayListOf<Interceptor>()

        interceptors.add(Interceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()
            builder.addHeader("app-version",BuildConfig.VERSION_NAME)
            builder.addHeader("device-type","android")

            val request = builder.method(original.method, original.body).build()
            return@Interceptor chain.proceed(request)
        })
        if (BuildConfig.DEBUG) {
            interceptors.add(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }


        val client = OkHttpClient.Builder()

        interceptors.forEach {
            client.addInterceptor(it)
        }
    return interceptors

}

