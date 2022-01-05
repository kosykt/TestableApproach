package com.example.testableapproach.data

import com.example.testableapproach.data.storage.StorageModel
import com.example.testableapproach.data.storage.StorageRepository
import com.example.testableapproach.domain.DomainModel
import com.example.testableapproach.domain.DomainRepository

class DomainRepositoryImpl(private val repository: StorageRepository): DomainRepository {

    override fun get(): DomainModel {
        val model = repository.getStorageModel()
        return mapToDomainModel(model)
    }

    private fun mapToDomainModel(model: StorageModel): DomainModel {
        return DomainModel(count = model.count)
    }
}