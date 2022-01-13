package com.example.testableapproach.data.repositories

import com.example.testableapproach.data.retrofit.model.GithubUsersDto

interface NetworkRepository {

    fun getUsersFromNetwork(): GithubUsersDto
}