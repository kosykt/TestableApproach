package com.example.testableapproach.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testableapproach.data.roomdatabase.AppDatabase
import com.example.testableapproach.data.roomdatabase.RoomModel
import com.example.testableapproach.data.storage.StorageModel
import com.example.testableapproach.data.storage.StorageRepository
import com.example.testableapproach.domain.DomainModel
import com.example.testableapproach.domain.DomainRepository

class DomainRepositoryImpl(
    private val repository: StorageRepository,
    application: Application
) : DomainRepository {

    private val roomDao = AppDatabase.getInstance(application).roomDao()

    init {
        roomDao.insert(RoomModel(111, 111))
    }

    override fun get(): LiveData<List<DomainModel>> = Transformations.map(
        repository.getStorageModel()
    ) {
        mapToDomainModel(it)
    }

    private fun mapToDomainModel(list: List<StorageModel>) = list.map {
        DomainModel(count = it.count)
    }
}