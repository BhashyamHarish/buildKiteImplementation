package com.saucelabs.mydemoapp.android.data.model

data class UserCredentials (

    val userEmail: String = "",
    val userPassword: String = "",
    val invalidUserEmail: String = "",
    val invalidUserPassword: String = "",
    val lockedUserEmail: String = "",
    val lockedUserPassword: String = ""
)