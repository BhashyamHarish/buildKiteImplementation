package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.pageObjects.helper.ActionHelper
import com.saucelabs.mydemoapp.android.utils.Logger

class LoginPageObjects {
    private val menuIcon: ViewInteraction = onView(ViewMatchers.withId(R.id.menuIV))
    private val loginText : ViewInteraction = onView(withText("Log In"))
    private val userNameTxtBox : ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val passwordTextBox : ViewInteraction  =  onView(ViewMatchers.withId(R.id.passwordET))
    private val loginBtn : ViewInteraction  = onView(ViewMatchers.withId(R.id.loginBtn))
    private val products : ViewInteraction = onView(ViewMatchers.withId(R.id.productTV))
    private val productsTitle : ViewInteraction  = onView(withText("Products"))
    private val loginTitle : ViewInteraction  = onView(ViewMatchers.withId(R.id.loginTV))
    private val menuView: ViewInteraction = onView(ViewMatchers.withId(R.id.menuRV))
    private val userNameError : ViewInteraction = onView(ViewMatchers.withId(R.id.nameErrorTV))
    private val passwordError : ViewInteraction = onView(ViewMatchers.withId(R.id.passwordErrorTV))

    private val helper = ActionHelper()
    fun clickMenuIcon() {
        try {
            helper.performClick(menuIcon)
            Logger.debug("LoginScreenActions", "Menu icon clicked successfully.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to click menu icon", e)
        }
    }

    fun clickLoginButtonOnDrawer() {
        try {
            helper.clickOnRecyclerViewItemWithText(menuView, AppConstants.LOGIN)
            Logger.debug("LoginScreenActions", "Login button on drawer clicked successfully.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to click login button on drawer", e)
        }
    }

    fun enterUserName(userID: String) {
        try {
            helper.enterText(userNameTxtBox, userID)
            Logger.debug("LoginScreenActions", "Entered username: $userID")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to enter username: $userID", e)
        }
    }

    fun enterPassword(password: String) {
        try {
            helper.enterText(passwordTextBox, password)
            Logger.debug("LoginScreenActions", "Entered password successfully.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to enter password", e)
        }
    }

    fun clickLoginButton() {
        try {
            helper.performClick(loginBtn)
            Logger.debug("LoginScreenActions", "Login button clicked successfully.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to click login button", e)
        }
    }

    fun isProductTitleDisplayed() {
        try {
            val isVisible = helper.isElementVisibleOnScreen(productsTitle)
            Logger.debug("LoginScreenActions", "Product title visibility: $isVisible")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to verify product title visibility", e)
        }
    }

    fun isLoginTitleDisplayed() {
        try {
            val isVisible = helper.isElementVisibleOnScreen(loginTitle)
            Logger.debug("LoginScreenActions", "Login title visibility: $isVisible")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to verify login title visibility", e)
        }
    }

    fun LoginIntoTheApplication(userID: String, password: String) {
        try {
            clickMenuIcon()
            clickLoginButtonOnDrawer()
            enterUserName(userID)
            enterPassword(password)
            clickLoginButton()
            isProductTitleDisplayed()
            Logger.info("LoginScreenActions", "Login into the application completed successfully.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to log into the application", e)
        }
    }

    fun isUserNameErrorShown(errorMessage: String) {
        try {
            helper.verifyText(userNameError, errorMessage)
            Logger.debug("LoginScreenActions", "Username error message verified: $errorMessage")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to verify username error message", e)
        }
    }

    fun isPasswordErrorShown(errorMessage: String) {
        try {
            helper.verifyText(passwordError, errorMessage)
            Logger.debug("LoginScreenActions", "Password error message verified: $errorMessage")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Failed to verify password error message", e)
        }
    }

    fun errorMessageLoginValidation(userID: String, password: String) {
        try {
            clickMenuIcon()
            clickLoginButtonOnDrawer()
            enterUserName(userID)
            enterPassword(password)
            clickLoginButton()
            Logger.info("LoginScreenActions", "Error message login validation completed.")
        } catch (e: Exception) {
            Logger.e("LoginScreenActions", "Error during error message login validation", e)
        }
    }}