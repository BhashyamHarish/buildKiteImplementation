package com.saucelabs.mydemoapp.android.e2eTests.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.data.model.MultipleUsersData
import com.saucelabs.mydemoapp.android.pageObjects.LoginPageObjects
import com.saucelabs.mydemoapp.android.utils.Logger
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.concurrent.CountDownLatch


@RunWith(AndroidJUnit4::class)
class LoginTest :  BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPageObjects()
    private val loginCredentials = DataBinder().getLoginCredentials()

    @Regression
    @Tag("Regression")
    @Test
    fun loginToTheApplicationOne() {
        try {
            loginPage.LoginIntoTheApplication(
                loginCredentials.userEmail,
                loginCredentials.userPassword
            )
        } catch (e: Exception) {
            Logger.e("LoginTest", "Error during login to the application", e)
            throw e // Rethrow to allow the test framework to handle the failure
        }
    }



}
