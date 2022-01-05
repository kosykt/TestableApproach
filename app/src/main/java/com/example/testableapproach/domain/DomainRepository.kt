package com.example.testableapproach.domain

import androidx.lifecycle.LiveData

interface DomainRepository {

    fun get(): LiveData<List<DomainModel>>
}