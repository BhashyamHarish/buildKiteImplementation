package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.internal.runner.ClassPathScanner.ExcludePackageNameFilter
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class ProductDetailsPageObjects {
    private val productTitle:ViewInteraction = onView(ViewMatchers.withId(R.id.productTV))
    private val productImage : ViewInteraction = onView((ViewMatchers.withId(R.id.productIV)))
    private val productView: ViewInteraction = onView(ViewMatchers.withId(R.id.productRV))
    private val priceTitle :ViewInteraction = onView(ViewMatchers.withId(R.id.priceTV))
    private val colorsBtn : ViewInteraction = onView(ViewMatchers.withId(R.id.colorRV))
    private val plusBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.plusIV))
    private val minusBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.minusIV))
    private val addToCartBtn: ViewInteraction = onView(ViewMatchers.withId(R.id.cartBt))
    private val cartIcon:ViewInteraction = onView(ViewMatchers.withId(R.id.cartRL))
    private val description : ViewInteraction = onView(ViewMatchers.withId(R.id.descTV))
    val parentId = R.id.infoCL
    val addtocartLL = R.id.addToCartLL
    val removeBtn = R.id.removeBt


    private val helper = ActionHelper()
    fun scrollToDescription() {
        try {
            helper.scrollToElement(description)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error scrolling to description", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isPriceDisplayed() {
        try {
            helper.isElementVisibleOnScreen(priceTitle)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error checking if price is displayed", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun isImageDisplayed() {
        try {
            helper.isElementVisibleOnScreen(productImage)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error checking if image is displayed", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun selectColor(index: Int) {
        try {
            helper.clickOnElementWithIndex(colorsBtn, index)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error selecting color", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickAddToCart() {
        try {
            helper.performClick(addToCartBtn)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error clicking add to cart button", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun addItemToCart(index: Int) {
        try {
            scrollToDescription()
            isImageDisplayed()
            isPriceDisplayed()
            selectColor(index)
            clickAddToCart()
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error adding item to cart", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickOnCart() {
        try {
            helper.performClick(cartIcon)
        } catch (e: Exception) {
            Logger.e("ProductDetails", "Error clicking on cart", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun clickAdd(){
        try{
            helper.performClick(plusBtn)
        }
        catch(e: Exception){
            Logger.e("ProductDetails", "Error clicking on Add", e)
        }
    }
    fun clickMinus(){
        try{
            helper.performClick(minusBtn)
        }
        catch(e: Exception){
            Logger.e("ProductDetails", "Error clicking on minus", e)
        }
    }
    fun getBagTitleInDetailsPage():String{
        var title = ""
        try {
           title =  helper.extractText(productTitle)
        }
        catch(e: Exception){
            Logger.e("ProductDetails", "Error getting in title", e)
        }
        return title
    }
    fun something(child1: String){
       helper.clickOnRemoveItem(child1,"Remove Item")

    }
    fun scrollInto(text: String){
      //  helper.testScrollToItemWithText(productView, text)
      //  helper.clickOnRecyclerViewItemWithText(productView,"Remove Item")
        helper.clickOnButtonWithTextInRecyclerView(productView,text, removeBtn)
    }

//token="mgRJwef5QoBdLvYWpfGZ87QS"

}