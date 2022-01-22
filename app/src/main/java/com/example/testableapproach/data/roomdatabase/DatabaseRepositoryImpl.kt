package com.example.testableapproach.data.roomdatabase

import com.example.testableapproach.data.repositories.DatabaseRepository

class DatabaseRepositoryImpl(private val db: AppDatabase) : DatabaseRepository {
    override suspend fun save(data: List<RoomModel>) {
        db.roomDao().insert(data)
    }

    override suspend fun getById(id: String): RoomModel? {
        return db.roomDao().getById(id)
    }
}