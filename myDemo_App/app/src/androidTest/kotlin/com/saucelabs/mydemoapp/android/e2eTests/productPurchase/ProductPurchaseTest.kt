package com.saucelabs.mydemoapp.android.e2eTests.productPurchase

import androidx.test.espresso.Espresso.pressBack
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.pageObjects.MyCartPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.CheckOutPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.LoginPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.PaymentDetailsPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.ProductDetailsPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.ProductListPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.ReviewOrderPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.SuccessPagePageObjects
import com.saucelabs.mydemoapp.android.utils.Logger
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test


class ProductPurchaseTest :  BaseTest<SplashActivity>(SplashActivity::class.java){

    //classes
    private val loginPage = LoginPageObjects()
    private val productListPage = ProductListPageObjects()
    private val productDetailsPageObjects = ProductDetailsPageObjects()
    private val cartPageObjects = MyCartPageObjects()
    private val checkOutPageObjects = CheckOutPageObjects()
    private val paymentDetailsPageObjects = PaymentDetailsPageObjects()
    private val reviewOrderPageObjects = ReviewOrderPageObjects()
    private val successPagePageObjects = SuccessPagePageObjects()
    //DataBinder classes
    private val loginCredentials = DataBinder().getLoginCredentials() // change the object
    private val paymentDetails = DataBinder().getPaymentDetails()
    private val shippingAddress = DataBinder().getShippingAddress()

    @Regression
    @Tag("Smoke")
    @Test
    fun checkOutMultipleProducts(){
        try {
            loginPage.LoginIntoTheApplication(loginCredentials.userPassword, loginCredentials.userPassword)
            productListPage.clickOnProductFromRecycler(0)
            val bag1 = productDetailsPageObjects.getBagTitleInDetailsPage()
            productDetailsPageObjects.scrollToDescription()
            productDetailsPageObjects.addItemToCart(index = 2)
            pressBack()
            productListPage.clickOnProductFromRecycler(2)
            val bag2 = productDetailsPageObjects.getBagTitleInDetailsPage()
            productDetailsPageObjects.scrollToDescription()
            productDetailsPageObjects.clickAddToCart()
            pressBack()
            productListPage.clickOnProductFromRecycler(3)
            val bag3 = productDetailsPageObjects.getBagTitleInDetailsPage()
            productDetailsPageObjects.scrollToDescription()
            productDetailsPageObjects.clickAddToCart()
            productDetailsPageObjects.clickOnCart()
            cartPageObjects.clickOnCheckOut()
            checkOutPageObjects.fillPersonalDetails(
                shippingAddress.fullName, shippingAddress.address1, shippingAddress.address2,
                shippingAddress.city, shippingAddress.city, shippingAddress.zip, shippingAddress.country
            )
            paymentDetailsPageObjects.fillCardDetails(
                paymentDetails.cardHolderName, paymentDetails.cardNumber, paymentDetails.expiredDate,
                paymentDetails.securityCode
            )
            reviewOrderPageObjects.isCheckOutComponentsVisible()
            successPagePageObjects.verifySuccessPage()
        } catch (e: Exception) {
            Logger.e("PurchaseFlow", "Error during multiple products checkout flow", e)
        }
    }

    @Tag("Smoke")
    @Test
    fun productPurchaseValidation(){
        try {
            loginPage.LoginIntoTheApplication(loginCredentials.userPassword, loginCredentials.userPassword)
            productListPage.clickOnProductFromRecycler(0)
            productDetailsPageObjects.scrollToDescription()
            productDetailsPageObjects.addItemToCart(index = 2)
            productDetailsPageObjects.clickOnCart()
            cartPageObjects.clickOnCheckOut()
            checkOutPageObjects.fillPersonalDetails(
                shippingAddress.fullName, shippingAddress.address1, shippingAddress.address2,
                shippingAddress.city, shippingAddress.city, shippingAddress.zip, shippingAddress.country
            )
            paymentDetailsPageObjects.fillCardDetails(
                paymentDetails.cardHolderName, paymentDetails.cardNumber, paymentDetails.expiredDate,
                paymentDetails.securityCode
            )
            reviewOrderPageObjects.isCheckOutComponentsVisible()
            successPagePageObjects.verifySuccessPage()
        } catch (e: Exception) {
            Logger.e("PurchaseFlow", "Error during complete purchase flow", e)
        }
    }

    @Tag("Smoke")
    @Test
    fun verifyCheckOutWithEmptyCart(){
        try {
            loginPage.LoginIntoTheApplication(loginCredentials.userPassword, loginCredentials.userPassword)
            productListPage.clickOnProductFromRecycler(0)
            productDetailsPageObjects.scrollToDescription()
            productDetailsPageObjects.addItemToCart(index = 2)
            productDetailsPageObjects.clickOnCart()
            cartPageObjects.clickOnCheckOut()
            checkOutPageObjects.fillPersonalDetails(
                shippingAddress.fullName, shippingAddress.address1, shippingAddress.address2,
                shippingAddress.city, shippingAddress.city, shippingAddress.zip, shippingAddress.country
            )
            paymentDetailsPageObjects.fillCardDetails(
                paymentDetails.cardHolderName, paymentDetails.cardNumber, paymentDetails.expiredDate,
                paymentDetails.securityCode
            )
            reviewOrderPageObjects.isCheckOutComponentsVisible()
            successPagePageObjects.verifySuccessPage()
        } catch (e: Exception) {
            Logger.e("PurchaseFlow", "Error during complete purchase flow", e)
        }
    }

}