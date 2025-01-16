package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class LogOutPageObjects {

    private val logOutText: ViewInteraction = onView(withText("Log Out"))
    private val logOutBtn: ViewInteraction = onView(withText("LOGOUT"))
    private val cancelBtn: ViewInteraction = onView(withText("CANCEL"))


    private val helper = ActionHelper()

    fun clickLogoutOnMenu() {
        try {
            helper.performClick(logOutText)
        } catch (e: Exception) {
            Logger.e("LogOut", "Error clicking logout on menu", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickLogOutOnPopUp() {
        try {
            helper.performClick(logOutBtn)
        } catch (e: Exception) {
            Logger.e("LogOut", "Error clicking logout on popup", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isCancelBtnPresent() {
        try {
            helper.isElementVisibleOnScreen(cancelBtn)
        } catch (e: Exception) {
            Logger.e("LogOut", "Error checking cancel button presence", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun logOutFromApplication() {
        try {
            clickLogoutOnMenu()
            isCancelBtnPresent()
            clickLogOutOnPopUp()
        } catch (e: Exception) {
            Logger.e("LogOut", "Error during logout process", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }


}