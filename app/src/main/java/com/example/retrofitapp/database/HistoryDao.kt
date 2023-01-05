package com.example.retrofitapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitapp.mvvm.CalculateModel

@Dao
interface HistoryDao {
    @Query("SELECT * FROM calculatemodel")
    fun getAllFromHistory(): List<CalculateModel>

    @Insert
    fun addToHistory(model: CalculateModel)

}