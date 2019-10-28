package com.example.bigboisonly

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import android.content.Context
import android.content.SharedPreferences
import me.ibrahimsn.library.LiveSharedPreferences

class CountRepository(context: Context) {
    //Create the Shared Preferences
    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    //Initialize the Shared Preferences in Private Mode
    init {
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = LiveSharedPreferences(preferences)
    }

    //Sets the User Count in Storage
    fun setUserCount(name: String, count: Long) {
        preferences.edit().putLong(name, count).apply()
    }

    //Sets the User Name in Storage
    fun getUserCount(name: String): LiveData<Long> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name),0L)) {it[name]}

    //Creates the Constant Value for the Storage
    companion object {
        private const val PREFS = "clickCounts"
    }
}