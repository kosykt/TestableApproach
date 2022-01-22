package com.example.testableapproach.domain

import com.example.testableapproach.data.roomdatabase.RoomModel
import com.example.testableapproach.domain.model.DomainUsersModel

interface DomainRepository {

    suspend fun getFromNetwork(): List<DomainUsersModel>

    suspend fun getById(id: String): RoomModel?
}