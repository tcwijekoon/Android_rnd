package com.example.hiltroom.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
sealed interface AppDao{

    @Query(value = "Select * from user order by id DESC")
    fun getRecords() : List<UserEntity>

    @Insert
    fun insertRecords(userEntity: UserEntity)
}