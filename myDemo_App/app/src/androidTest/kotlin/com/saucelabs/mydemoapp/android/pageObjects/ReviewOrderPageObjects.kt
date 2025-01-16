package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class ReviewOrderPageObjects {

    private val addresslayOut: ViewInteraction = onView(ViewMatchers.withId(R.id.addressLL))
    private val amount : ViewInteraction = onView(ViewMatchers.withId(R.id.amountTV))
    private val paymentBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))

    private val helper = ActionHelper()
    fun isAddresslayOutPresent() {
        try {
            helper.scrollToElement(addresslayOut)
            helper.isElementVisibleOnScreen(addresslayOut)
        } catch (e: Exception) {
            Logger.e("Review Order Page Objects", "Error checking if address layout is present", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isAmountPresent() {
        try {
            helper.scrollToElement(amount)
            helper.isElementVisibleOnScreen(amount)
        } catch (e: Exception) {
            Logger.e("Review Order Page Objects", "Error checking if amount is present", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickPaymentButton() {
        try {
            helper.performClick(paymentBtn)
        } catch (e: Exception) {
            Logger.e("Review Order Page Objects", "Error clicking payment button", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isCheckOutComponentsVisible() {
        try {
            isAddresslayOutPresent()
            isAmountPresent()
            clickPaymentButton()
        } catch (e: Exception) {
            Logger.e("Review Order Page Objects", "Error during checkout component visibility check", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }



}