package com.example.testableapproach.domain

import com.example.testableapproach.domain.model.DomainUsersModel

interface DomainRepository {

    suspend fun getFromNetwork(): List<DomainUsersModel>
}