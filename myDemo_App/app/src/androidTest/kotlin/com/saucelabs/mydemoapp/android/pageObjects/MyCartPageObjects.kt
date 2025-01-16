package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.constants.Messages
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger


class MyCartPageObjects {
    private val removeBtn : ViewInteraction = onView(ViewMatchers.withId(R.id.removeBt))
    private val priceLabel : ViewInteraction = onView(ViewMatchers.withId(R.id.totalPriceTV))
    private val totalItems : ViewInteraction = onView(ViewMatchers.withId(R.id.itemsTV))
    private val proceedToCheckOutBtn : ViewInteraction = onView(ViewMatchers.withId(R.id.cartBt))
    private val cartInfoText : ViewInteraction = onView(ViewMatchers.withId(R.id.cartInfoLL))

    private val helper = ActionHelper()

    fun clickOnCheckOut(){
        try{
            helper.performClick(proceedToCheckOutBtn)
        }catch(e: Exception){
            Logger.e("MyCartPage", "Error during My CartPage process", e)

        }        }

    fun verifyCartPageWithoutAnyProduct(){
        try{
            helper.verifyTextWithContains(cartInfoText, Messages.VERIFYING_EMPTY_CART_MESSAGE)
        }
        catch(e: Exception){
            Logger.e("MyCartPage", "Error on cartPage objects process", e)
        }
    }





}