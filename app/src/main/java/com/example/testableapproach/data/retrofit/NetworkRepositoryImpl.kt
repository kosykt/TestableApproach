package com.example.testableapproach.data.retrofit

import com.example.testableapproach.data.repositories.NetworkRepository
import com.example.testableapproach.data.retrofit.model.GithubUsersDto

class NetworkRepositoryImpl(private val retrofitService: RetrofitService): NetworkRepository {

    override suspend fun getUsersFromNetwork(): List<GithubUsersDto> {
        return retrofitService.getTest()
    }
}