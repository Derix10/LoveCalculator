package com.example.retrofitapp

import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class Repository {

    fun makeRequest(secondName: String, firstName: String): MutableLiveData<CalculateModel> {
        val liveData = MutableLiveData<CalculateModel>()
        App.api.getPercentage(secondName, firstName).enqueue(
            object : retrofit2.Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
                    liveData.postValue(response.body())

                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }

        )
        return liveData
    }
}