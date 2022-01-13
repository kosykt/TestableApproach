package com.example.testableapproach.domain

import com.example.testableapproach.domain.model.DomainUsersModel

interface DomainRepository {

    fun get(): List<DomainUsersModel>
}