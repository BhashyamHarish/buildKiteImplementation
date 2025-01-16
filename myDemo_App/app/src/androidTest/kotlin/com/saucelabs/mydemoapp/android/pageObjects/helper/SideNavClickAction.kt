package com.saucelabs.mydemoapp.android.pageObjects.helper

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import com.saucelabs.mydemoapp.android.R
import org.hamcrest.Matcher

class SideNavClickAction : ViewAction {
    override fun getConstraints(): Matcher<View>? {
        return null
    }

    override fun getDescription(): String {
        return "Click on a child view with specified id."
    }

    override fun perform(uiController: UiController, view: View) {
        val v = view.findViewById<View>(R.id.itemTV)
        v.performClick()
    }
}
