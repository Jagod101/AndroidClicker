package com.example.bigboisonly

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.bigboisonly.util.rotate90
import com.example.bigboisonly.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var chapmanCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            chapmanCounter = savedInstanceState.getInt(CHAPMAN_COUNTER_KEY, 0)
        }
        myButton.setOnClickListener {
            chapmanCounter++
            myCounter.text = "Count: " + chapmanCounter.toString()
            myImage.rotate90()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putInt(CHAPMAN_COUNTER_KEY, chapmanCounter)
        }

        super.onSaveInstanceState(outState)

    }

    companion object {
        private const val CHAPMAN_COUNTER_KEY = "chapmanCounterKey"
    }
}
