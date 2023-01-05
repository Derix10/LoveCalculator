package com.example.retrofitapp.hilt

import android.content.Context
import android.content.SharedPreferences
import com.example.retrofitapp.database.HistoryDao
import com.example.retrofitapp.database.HistoryDataBase
import com.example.retrofitapp.retrofit.CalculateApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {

    @Provides
    @Singleton
    fun provideApi(): CalculateApi {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CalculateApi::class.java)
    }


    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("isShow", Context.MODE_PRIVATE)
    }

}



