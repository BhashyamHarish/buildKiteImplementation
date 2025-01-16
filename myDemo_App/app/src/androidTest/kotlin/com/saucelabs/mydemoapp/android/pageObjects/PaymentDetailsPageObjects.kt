package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class PaymentDetailsPageObjects {

    private val paymentBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))
    private val cardName: ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val cardNumber: ViewInteraction = onView(ViewMatchers.withId(R.id.cardNumberET))
    private val expirationDate: ViewInteraction = onView(ViewMatchers.withId(R.id.expirationDateET))
    private val securityCode: ViewInteraction = onView(ViewMatchers.withId(R.id.securityCodeET))

    private val helper = ActionHelper()

    fun clickPaymentButton() {
        try {
            helper.performClick(paymentBtn)
        } catch (e: Exception) {
            Logger.e("Payment", "Error clicking payment button", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillCardName(name: String) {
        try {
            helper.enterText(cardName, name)
        } catch (e: Exception) {
            Logger.e("Payment", "Error filling card name", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillCardNumber(number: String) {
        try {
            helper.enterText(cardNumber, number)
        } catch (e: Exception) {
            Logger.e("Payment", "Error filling card number", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillExpirationNumber(expNumber: String) {
        try {
            helper.enterText(expirationDate, expNumber)
        } catch (e: Exception) {
            Logger.e("Payment", "Error filling expiration number", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillSecurityCode(code: String) {
        try {
            helper.enterText(securityCode, code)
        } catch (e: Exception) {
            Logger.e("Payment", "Error filling security code", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillCardDetails(name: String, number: String, expNumber: String, code: String) {
        try {
            fillCardName(name)
            fillCardNumber(number)
            fillExpirationNumber(expNumber)
            fillSecurityCode(code)
            clickPaymentButton()
        } catch (e: Exception) {
            Logger.e("Payment", "Error filling card details", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }


}