package com.example.testableapproach.data.retrofit

import com.example.testableapproach.data.retrofit.model.RetrofitModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    fun getCashPayment(): Call<RetrofitModel>
}