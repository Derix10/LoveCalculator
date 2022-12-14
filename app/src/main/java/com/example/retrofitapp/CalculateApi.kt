package com.example.retrofitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
//url: 'https://love-calculator.p.rapidapi.com/getPercentage',
//params: {sname: 'Alice', fname: 'John'},
//headers: {
//    'X-RapidAPI-Key': '164abdd358msh332a4b266de48d7p1ac937jsn67dfb7e18c66',
//    'X-RapidAPI-Host': 'love-calculator.p.rapidapi.com'
interface CalculateApi {


    @GET("getPercentage")
    fun getPercentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key : String = "164abdd358msh332a4b266de48d7p1ac937jsn67dfb7e18c66",
        @Header("X-RapidAPI-Host") host : String = "love-calculator.p.rapidapi.com"


        ): Call<CalculateModel>
}