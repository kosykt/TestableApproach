package com.example.testableapproach.domain

import com.example.testableapproach.domain.model.DomainUsersModel

class GetUseCase(private val repository: DomainRepository) {

    fun execute(): List<DomainUsersModel> {
        return repository.get()
    }
}