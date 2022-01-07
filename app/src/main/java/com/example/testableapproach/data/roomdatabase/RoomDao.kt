package com.example.testableapproach.data.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: RoomModel)

    @Query("SELECT * FROM RoomModel")
    fun getAll(): List<RoomModel>
}