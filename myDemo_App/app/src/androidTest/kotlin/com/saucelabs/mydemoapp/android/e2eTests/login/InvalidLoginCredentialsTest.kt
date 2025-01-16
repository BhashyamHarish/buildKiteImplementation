package com.saucelabs.mydemoapp.android.e2eTests.login

import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.constants.Messages
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.pageObjects.LoginPageObjects
import com.saucelabs.mydemoapp.android.utils.Logger
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test

class InvalidLoginCredentialsTest: BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPageObjects()
    private val loginCredentials = DataBinder().getLoginCredentials()

    @Tag("Regression")
    @Test
    fun errorMessageValidationForUserName() {
        try {
            loginPage.errorMessageLoginValidation(
                "",
                loginCredentials.userPassword
            )
            loginPage.isUserNameErrorShown(Messages.USER_NAME_IS_REQUIRED)
        } catch (e: Exception) {
            Logger.e("UserNameValidationTest", "Error during username validation test", e)
            throw e
        }
    }
    @Regression
    @Tag("Regression")
    @Test
    fun errorMessageValidationForPassword() {
        try {
            loginPage.errorMessageLoginValidation(
                loginCredentials.userEmail,
                ""
            )
            loginPage.isPasswordErrorShown(Messages.PASSWORD_IS_REQUIRED)
        } catch (e: Exception) {
            Logger.e("PasswordValidationTest", "Error during password validation test", e)
            throw e
        }
    }

    @Regression
    @Tag("Regression")
    @Test
    fun errorMessageValidationWithOutAnyCredentials() {
        try {
            loginPage.errorMessageLoginValidation(
                "",
                ""
            )
            loginPage.isUserNameErrorShown(Messages.USER_NAME_IS_REQUIRED)
        } catch (e: Exception) {
            Logger.e("UserNameValidationTest", "Error during no data validation test", e)
            throw e
        }
    }

}