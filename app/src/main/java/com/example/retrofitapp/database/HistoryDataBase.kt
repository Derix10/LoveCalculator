package com.example.retrofitapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitapp.mvvm.CalculateModel

@Database(entities = [CalculateModel::class], version = 1)
abstract class HistoryDataBase : RoomDatabase(){

    abstract fun historyDao(): HistoryDao

    companion object{

        @Volatile
        private var instance : HistoryDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDB(context).also{
                instance = it
            }
        }

        private fun buildDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HistoryDataBase::class.java,
                "DB_NAME"
            ).allowMainThreadQueries().build()
    }




}