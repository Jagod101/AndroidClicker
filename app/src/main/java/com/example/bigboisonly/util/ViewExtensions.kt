package com.example.bigboisonly.util

import android.view.View

//toggleVisibility() adjusts the object from being Visible and Invisible
fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) {View.INVISIBLE } else {View.VISIBLE }
}

//rotate90() rotates an object 90 degrees clockwise
fun View.rotate90() {
    rotation = (rotation + 90) % 360
}

