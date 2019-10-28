package com.example.bigboisonly.view

import androidx.lifecycle.ViewModelProviders
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bigboisonly.R
import com.example.bigboisonly.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Late Initialize the Count View Model, Initializing the Counter
    private lateinit var countViewModel: CountViewModel
    private var chapmanCounter: Long = 0

    //getUserName() is a username function to take the String entered on the Login Page to assign to the User
    private fun getUserName() = intent.extras?.get("username").toString().trim()
    //fun getStore() = getPreferences(Context.MODE_PRIVATE)
    //var CHAPMAN_COUNTER_KEY: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val name = intent.extras?.get("username").toString().trim()
//        CHAPMAN_COUNTER_KEY = name
//
//        if (savedInstanceState != null) {
//            updateCounter(savedInstanceState.getLong(CHAPMAN_COUNTER_KEY, 0))
//        } else if (getStore().contains(CHAPMAN_COUNTER_KEY)) {
//            updateCounter(getStore().getLong(CHAPMAN_COUNTER_KEY, 0))
//        }

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUserName()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        //Executes when the Button is Clicked by the User
        myButton.setOnClickListener {
            chapmanCounter++ //Counter Updates by ++ (+1) per click
            myCounter.text = "Chapman Points: " + chapmanCounter.toString() //Displays the updated Counter Value
            //myImage.rotate90()

            //myButton.text = when (chapmanCounter) {
            //    1L -> "stop"
            //    in 2 .. 9 -> myButton.text.toString().plus("!")
            //    else -> myButton.text
            //}

            //Sets the User variables so they are saved
            countViewModel.setUserCount(getUserName(), chapmanCounter + 1)
        }
    }

    //Updates the displayed Counter
    private fun updateCounter(count: Long) {
        chapmanCounter = count
        myCounter.text = chapmanCounter.toString()
    }

//    override fun onPause() {
//        super.onPause()
//        getStore().edit().putLong(CHAPMAN_COUNTER_KEY, chapmanCounter).apply()
//    }
//    override fun onSaveInstanceState(outState: Bundle?) {
//        outState?.run {
//            putLong(CHAPMAN_COUNTER_KEY, chapmanCounter)
//        }
//
//        super.onSaveInstanceState(outState)
//
//    }

    //companion object {
    //    private const val CHAPMAN_COUNTER_KEY = "chapmanCounterKey"
    //}
}
