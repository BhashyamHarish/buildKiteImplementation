package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class SuccessPagePageObjects {

    private val thankYouText: ViewInteraction = onView(ViewMatchers.withId(R.id.thankYouTV))
    private val orderConfimationTxt : ViewInteraction = onView(ViewMatchers.withId(R.id.orderTV))
    private val continueShopingBtn : ViewInteraction = onView(ViewMatchers.withId(R.id.shoopingBt))
    private val checkOutComplete: ViewInteraction = onView(ViewMatchers.withId(R.id.completeTV))

    private val helper = ActionHelper()
    fun isThankYouTitleIsShown() {
        try {
            helper.isElementVisibleOnScreen(thankYouText)
        } catch (e: Exception) {
            Logger.e("SuccessPage", "Error checking if thank you title is shown", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickContinueShoppingButton() {
        try {
            helper.performClick(continueShopingBtn)
        } catch (e: Exception) {
            Logger.e("SuccessPage", "Error clicking continue shopping button", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isCheckOutConfirmed() {
        try {
            helper.isElementVisibleOnScreen(checkOutComplete)
        } catch (e: Exception) {
            Logger.e("SuccessPage", "Error checking if checkout is confirmed", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun verifySuccessPage() {
        try {
            isCheckOutConfirmed()
            isThankYouTitleIsShown()
            clickContinueShoppingButton()
        } catch (e: Exception) {
            Logger.e("SuccessPage", "Error verifying success page", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }


}