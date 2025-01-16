package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class ProductListPageObjects {
    private val productImages : ViewInteraction = onView(ViewMatchers.withId(R.id.productIV))
    private val productTitle :ViewInteraction = onView(ViewMatchers.withId(R.id.titleTV))
    private val priceTitle :ViewInteraction = onView(ViewMatchers.withId(R.id.priceTV))
    private val productLists :ViewInteraction = onView(ViewMatchers.withId(R.id.productRV))
    private val sortButton : ViewInteraction = onView(ViewMatchers.withId(R.id.sortIV))
    private val ascendingTxt : ViewInteraction = onView(ViewMatchers.withText("Price - Ascending"))
    private val descendingTxt : ViewInteraction = onView(ViewMatchers.withText("Price - Descending"))
    val recyclerViewId = R.id.productRV
    val childViewId = R.id.titleTV
    val priceViewID = R.id.priceTV


    private val helper = ActionHelper()

    fun clickOnProductFromRecycler(index: Int){
        try{
            helper.clickOnElementWithIndex(productLists, index)
        }catch(e: Exception){
            Logger.e("ProductListPage", "Error during error message login validation", e)
        }
    }

    fun getTitleBeforeSorting():String {
        return try {
            helper.extractTextFromRecyclerViewAtPosition(recyclerViewId, 0, childViewId)
        }catch(e: Exception){
            Logger.e("ProductListPage", "unable to extract text check", e)
            ""
        }
    }
    fun getPricessBeforeSorting():List<String> {
        val priceList = helper.extractAllTextsFromRecyclerView(productLists, priceViewID)
        println("harishgoud list $priceList")
        return try {
            helper.extractAllTextsFromRecyclerView(productLists, priceViewID)
        }catch(e: Exception){
            Logger.e("ProductListPage", "unable to extract text check", e)
            emptyList()
        }
    }

}