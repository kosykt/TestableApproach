package com.example.testableapproach.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testableapproach.data.storage.StorageModel
import com.example.testableapproach.data.storage.StorageRepository
import com.example.testableapproach.domain.DomainModel
import com.example.testableapproach.domain.DomainRepository

class DomainRepositoryImpl(private val repository: StorageRepository) : DomainRepository {

    override fun get(): LiveData<List<DomainModel>> = Transformations.map(
        repository.getStorageModel()
    ) {
        mapToDomainModel(it)
    }

    private fun mapToDomainModel(list: List<StorageModel>) = list.map {
        DomainModel(count = it.count)
    }
}