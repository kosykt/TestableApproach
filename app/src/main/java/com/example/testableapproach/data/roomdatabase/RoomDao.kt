package com.example.testableapproach.data.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: List<RoomModel>)

    @Query("SELECT * FROM RoomModel")
    suspend fun getAll(): List<RoomModel>

    @Query("SELECT * FROM RoomModel WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): RoomModel?
}