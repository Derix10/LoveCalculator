package com.example.retrofitapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel : ViewModel() {
    val repository = Repository()

    fun makeRequest(secondName: String, firstName: String): LiveData<CalculateModel> {
        return repository.makeRequest(secondName, firstName)
    }
}