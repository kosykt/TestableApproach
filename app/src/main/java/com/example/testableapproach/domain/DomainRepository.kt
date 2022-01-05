package com.example.testableapproach.domain

interface DomainRepository {

    fun get(): DomainModel
}