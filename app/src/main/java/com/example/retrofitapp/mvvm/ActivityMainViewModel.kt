package com.example.retrofitapp.mvvm

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityMainViewModel @Inject constructor(private val repository : Repository,
                                  private val prefs: SharedPreferences) : ViewModel() {



    fun makeRequest(secondName: String, firstName: String): LiveData<CalculateModel> {
        return repository.makeRequest(secondName, firstName)
    }

    fun saveBoardState() {
        prefs.edit().putBoolean("isShow", true).apply()
    }


    fun isBoardShow(): Boolean{
        return prefs.getBoolean("isShow", false)

    }
}