package com.example.bigboisonly.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bigboisonly.R
import com.example.bigboisonly.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var countViewModel: CountViewModel
    private var chapmanCounter: Long = 0
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
        myButton.setOnClickListener {
            chapmanCounter++
            myCounter.text = "Chapman Points: " + chapmanCounter.toString()
            //myImage.rotate90()

            //myButton.text = when (chapmanCounter) {
            //    1L -> "stop"
            //    in 2 .. 9 -> myButton.text.toString().plus("!")
            //    else -> myButton.text
            //}
        }
    }

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
