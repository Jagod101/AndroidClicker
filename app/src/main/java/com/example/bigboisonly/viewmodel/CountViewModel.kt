package com.example.bigboisonly.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bigboisonly.CountRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext)

    //Retrieves the Count from the Repository
    fun getUserCount(name: String) = repository.getUserCount(name)

    //Sets the Count in the Repository
    fun setUserCount(name: String, count: Long) = repository.setUserCount(name,count)
}