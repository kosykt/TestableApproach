package com.example.testableapproach.data.retrofit

import com.example.testableapproach.data.retrofit.model.RetrofitModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCashPayment(): Response<RetrofitModel>
}