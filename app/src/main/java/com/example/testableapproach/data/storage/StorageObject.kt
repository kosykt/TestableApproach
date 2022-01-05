package com.example.testableapproach.data.storage

object StorageObject: StorageRepository {

    private val storageModel = StorageModel(10)

    override fun getStorageModel(): StorageModel {
        return storageModel
    }
}