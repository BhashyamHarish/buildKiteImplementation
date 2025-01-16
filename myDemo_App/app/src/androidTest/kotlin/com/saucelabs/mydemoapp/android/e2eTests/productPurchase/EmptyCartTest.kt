package com.saucelabs.mydemoapp.android.e2eTests.productPurchase

import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.pageObjects.LoginPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.MyCartPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.ProductDetailsPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.ProductListPageObjects
import com.saucelabs.mydemoapp.android.utils.Logger
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.utils.annotations.Smoke
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test

class EmptyCartTest : BaseTest<SplashActivity>(SplashActivity::class.java){
    private val loginPage = LoginPageObjects()
    private val productListPage = ProductListPageObjects()
    private val productDetailsPageObjects = ProductDetailsPageObjects()
    private val cartPageObjects = MyCartPageObjects()

    //DataBinder classes
    private val loginCredentials = DataBinder().getLoginCredentials() // change the object

    @Regression
    @Tag("Smoke")
    @Test
    fun productPurchaseValidation() {
        try {
            loginPage.LoginIntoTheApplication(
                loginCredentials.userPassword,
                loginCredentials.userPassword
            )
            productListPage.clickOnProductFromRecycler(0)
            productDetailsPageObjects.clickOnCart()
            cartPageObjects.verifyCartPageWithoutAnyProduct()
        }catch (e:Exception){
            Logger.e("EmptyCartTest", "Failed at method product purchase validation")
        }
    }
}