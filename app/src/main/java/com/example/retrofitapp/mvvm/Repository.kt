package com.example.retrofitapp.mvvm

import androidx.lifecycle.MutableLiveData
import com.example.retrofitapp.retrofit.CalculateApi
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api : CalculateApi) {

    fun makeRequest(secondName: String, firstName: String): MutableLiveData<CalculateModel> {
        val liveData = MutableLiveData<CalculateModel>()
        api.getPercentage(secondName, firstName).enqueue(
            object : retrofit2.Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
                    liveData.postValue(response.body())

                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    t.message
                }

            }

        )
        return liveData
    }
    }