package com.saucelabs.mydemoapp.android.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Logger {
    private const val GLOBAL_TAG = "EspressoFramework"

    // Timestamp format
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())

    // Get current timestamp
    private fun getTimestamp(): String {
        return dateFormat.format(Date())
    }

    // Debug log
    fun debug(tag: String = GLOBAL_TAG, message: String) {
        Log.d(tag, "${getTimestamp()} [DEBUG]: $message")
    }

    // Info log
    fun info(tag: String = GLOBAL_TAG, message: String) {
        Log.i(tag, "${getTimestamp()} [INFO]: $message")
    }

    // Error log
    fun e(tag: String = GLOBAL_TAG, message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            Log.e(tag, "${getTimestamp()} [ERROR]: $message", throwable)
        } else {
            Log.e(tag, "${getTimestamp()} [ERROR]: $message")
        }
    }
}
