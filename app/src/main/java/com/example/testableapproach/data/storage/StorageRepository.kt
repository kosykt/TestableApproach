package com.example.testableapproach.data.storage

import androidx.lifecycle.LiveData

interface StorageRepository {

    fun getStorageModel(): LiveData<List<StorageModel>>
}