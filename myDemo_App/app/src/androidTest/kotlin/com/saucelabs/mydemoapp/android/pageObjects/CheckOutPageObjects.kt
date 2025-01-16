package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class CheckOutPageObjects {
    private val fullNametxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.fullNameET))
    private val addressLineOnetxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.address1ET))
    private val addressLineTwotxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.address2ET))
    private val citytxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.cityET))
    private val statetxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.stateET))
    private val zipCodetxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.zipET))
    private val countrytxtbx: ViewInteraction = onView(ViewMatchers.withId(R.id.countryET))
    private val paymentBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))

    private val helper = ActionHelper()

    fun fillFullName(fullName: String) {
        try {
            helper.enterText(fullNametxtbx, fullName)
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling full name", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillAddressLine1(addressLine1: String) {
        try {
            helper.enterText(addressLineOnetxtbx, addressLine1)
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling address line 1", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillAddressLine2(addressLine2: String) {
        try {
            helper.enterText(addressLineTwotxtbx, addressLine2)
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling address line 2", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillCity(city: String) {
        try {
            helper.enterText(citytxtbx, city)
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling city", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillState(state: String) {
        try {
            helper.enterText(statetxtbx, state)
            closeSoftKeyboard()
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling state", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillZipcode(zipcode: String) {
        try {
            helper.enterText(zipCodetxtbx, zipcode)
            closeSoftKeyboard()
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling zipcode", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillCountry(country: String) {
        try {
            helper.enterText(countrytxtbx, country)
            closeSoftKeyboard()
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling country", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickPaymentButton() {
        try {
            helper.performClick(paymentBtn)
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error clicking payment button", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun fillPersonalDetails(
        fullName: String, addressLine1: String, addressLine2: String, city: String,
        state: String, zipcode: String, country: String
    ) {
        try {
            fillFullName(fullName)
            fillAddressLine1(addressLine1)
            fillAddressLine2(addressLine2)
            fillCity(city)
            fillState(state)
            fillZipcode(zipcode)
            fillCountry(country)
            clickPaymentButton()
        } catch (e: Exception) {
            Logger.e("FillPersonalDetails", "Error filling personal details", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

}
