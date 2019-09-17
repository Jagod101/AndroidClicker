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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            chapmanCounter = savedInstanceState.getLong(CHAPMAN_COUNTER_KEY, 0)
            myCounter.text = chapmanCounter.toString()
        }
        myButton.setOnClickListener {
            chapmanCounter++
            myCounter.text = "Counter: " + chapmanCounter.toString()
            myImage.rotate90()
        }
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

    companion object {
        private const val CHAPMAN_COUNTER_KEY = "chapmanCounterKey"
    }
}
