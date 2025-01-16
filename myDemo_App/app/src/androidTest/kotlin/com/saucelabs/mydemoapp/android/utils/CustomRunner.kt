package com.saucelabs.mydemoapp.android.utils
import androidx.test.runner.AndroidJUnitRunner
import org.junit.runners.JUnit4

class CustomRunner : AndroidJUnitRunner() {
    override fun onStart() {
        super.onStart()
    }
}