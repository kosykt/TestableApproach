package com.example.testableapproach.domain

class GetUseCase(private val repository: DomainRepository) {

    fun execute(): DomainModel{
        return repository.get()
    }
}