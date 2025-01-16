package com.saucelabs.mydemoapp.android.data.model


    data class MultipleUsersData (
        val userName: String = "",
        val password: String = ""

    )
    data class DataList(
        val tests: List<MultipleUsersData>
    )
