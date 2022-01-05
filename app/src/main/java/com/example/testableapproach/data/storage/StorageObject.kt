package com.example.testableapproach.data.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object StorageObject: StorageRepository {

    private val storageModel = MutableLiveData<List<StorageModel>>()

    init {
        storageModel.value = arrayListOf(StorageModel(10), StorageModel(5))
    }

    override fun getStorageModel(): LiveData<List<StorageModel>> {
        return storageModel
    }
}