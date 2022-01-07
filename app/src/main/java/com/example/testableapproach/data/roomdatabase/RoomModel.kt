package com.example.testableapproach.data.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val count: Int
)
