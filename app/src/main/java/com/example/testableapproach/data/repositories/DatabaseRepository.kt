package com.example.testableapproach.data.repositories

import com.example.testableapproach.data.roomdatabase.RoomModel

interface DatabaseRepository {

    suspend fun save(data: List<RoomModel>)
}