package com.example.testableapproach.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHolder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}