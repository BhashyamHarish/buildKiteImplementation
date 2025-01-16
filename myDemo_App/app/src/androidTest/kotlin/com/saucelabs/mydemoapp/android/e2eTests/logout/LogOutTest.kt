package com.saucelabs.mydemoapp.android.e2eTests.logout

import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.pageObjects.LogOutPageObjects
import com.saucelabs.mydemoapp.android.pageObjects.LoginPageObjects
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.utils.annotations.Smoke
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test

class LogOutTest : BaseTest<SplashActivity>(SplashActivity::class.java){

    private val loginPage = LoginPageObjects()
    private val logoutPage = LogOutPageObjects()

    private val loginCredentials = DataBinder().getLoginCredentials()

    @Smoke
    @Tag("Smoke")
    @Test
    fun logOutTheApplication(){
        loginPage.LoginIntoTheApplication(loginCredentials.userEmail, loginCredentials.userPassword)
        loginPage.clickMenuIcon()
        logoutPage.logOutFromApplication()
        loginPage.isLoginTitleDisplayed()
    }

    @Regression
    @Tag("Regression")
    @Test
    fun logOutTheApplicationOne(){
        loginPage.LoginIntoTheApplication(loginCredentials.userEmail, loginCredentials.userPassword)
        loginPage.clickMenuIcon()
        logoutPage.logOutFromApplication()
        loginPage.isLoginTitleDisplayed()
    }


}