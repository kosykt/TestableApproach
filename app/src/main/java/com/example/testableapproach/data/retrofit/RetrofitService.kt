package com.example.testableapproach.data.retrofit

import com.example.testableapproach.data.retrofit.model.GithubUsersDto
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    suspend fun getTest(): Response<GithubUsersDto>
}