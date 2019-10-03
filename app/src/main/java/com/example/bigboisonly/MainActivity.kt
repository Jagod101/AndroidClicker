package com.example.bigboisonly

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.bigboisonly.util.rotate90
import com.example.bigboisonly.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var chapmanCounter: Long = 0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)
    var CHAPMAN_COUNTER_KEY: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.extras?.get("username").toString().trim()
        CHAPMAN_COUNTER_KEY = name

        if (savedInstanceState != null) {
            updateCounter(savedInstanceState.getLong(CHAPMAN_COUNTER_KEY, 0))
        } else if (getStore().contains(CHAPMAN_COUNTER_KEY)) {
            updateCounter(getStore().getLong(CHAPMAN_COUNTER_KEY, 0))
        }
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
    override fun onPause() {
        super.onPause()
        getStore().edit().putLong(CHAPMAN_COUNTER_KEY, chapmanCounter).apply()
    }
    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putLong(CHAPMAN_COUNTER_KEY, chapmanCounter)
        }

        super.onSaveInstanceState(outState)

    }

    //companion object {
    //    private const val CHAPMAN_COUNTER_KEY = "chapmanCounterKey"
    //}
}
