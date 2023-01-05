package com.example.retrofitapp

import android.app.Application
import com.example.retrofitapp.database.HistoryDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){
    companion object{
        lateinit var db: HistoryDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = HistoryDataBase.invoke(this)
    }
}