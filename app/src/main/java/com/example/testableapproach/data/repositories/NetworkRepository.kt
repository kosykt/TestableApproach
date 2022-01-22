package com.example.testableapproach.data.repositories

import com.example.testableapproach.data.retrofit.model.GithubUsersDto

interface NetworkRepository {

    suspend fun getUsersFromNetwork(): List<GithubUsersDto>
}