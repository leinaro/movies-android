package com.leinaro.peiky.movies.Services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun create(): MovieDBServices {

    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val client =  OkHttpClient.Builder().addInterceptor(interceptor).build()
    val gson = GsonBuilder().setLenient().create()

    return Retrofit.Builder()
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://api.themoviedb.org/3/")
        .build()
        .create(MovieDBServices::class.java)
}
