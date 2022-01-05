package com.example.testableapproach.domain

import androidx.lifecycle.LiveData

class GetUseCase(private val repository: DomainRepository) {

    fun execute(): LiveData<List<DomainModel>> {
        return repository.get()
    }
}