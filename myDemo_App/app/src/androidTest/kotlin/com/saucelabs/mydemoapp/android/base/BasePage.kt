package com.saucelabs.mydemoapp.android.base

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
//import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
//import com.saucelabs.mydemoapp.android.pageObjects.Helper.Wait

open class BasePage {

   // private val handleView =    ViewActions()

    private val menuIV: ViewInteraction = onView(withId(R.id.menuIV))
    private val sortIV: ViewInteraction = onView(withId(R.id.sortIV))
    private val cartRL: ViewInteraction = onView(withId(R.id.cartRL))


    fun clickOnSortButton() {
    //    handleView.performClick(sortIV)
    }
    fun clickCart(){
        try {
     //       handleView.performClick(cartRL)
        }catch (e: Exception){
            e.message
        }
    }
    fun clickMenu() {
    //    Wait.waitView(menuIV)
     //   handleView.performClick(menuIV)
    }
}