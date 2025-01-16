package com.saucelabs.mydemoapp.android.data

import com.saucelabs.mydemoapp.android.data.model.DataList
import com.saucelabs.mydemoapp.android.data.model.MultipleUsersData
import com.saucelabs.mydemoapp.android.data.model.PaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ShippingAddress
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.utils.Logger

class DataBinder {
    fun getLoginCredentials(): UserCredentials {
        return try {
            JsonUtils.getData("loginCredentials.json", UserCredentials::class.java)
        } catch (e: Exception) {
            Logger.e("DataRetrieval", "Error retrieving login credentials", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun getPaymentDetails(): PaymentDetails {
        return try {
            JsonUtils.getData("paymentDetails.json", PaymentDetails::class.java)
        } catch (e: Exception) {
            Logger.e("DataRetrieval", "Error retrieving payment details", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun getShippingAddress(): ShippingAddress {
        return try {
            JsonUtils.getData("shippingAddress.json", ShippingAddress::class.java)
        } catch (e: Exception) {
            Logger.e("DataRetrieval", "Error retrieving shipping address", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }

    fun getMultipleData(): List<MultipleUsersData> {
        return try {
            val dataList = JsonUtils.getData("dataSet.json", DataList::class.java)
            if (dataList != null && dataList.tests != null) {
                dataList.tests
            } else {
                throw IllegalStateException("Failed to load test data from JSON")
            }
        } catch (e: Exception) {
            Logger.e("DataRetrieval", "Error retrieving multiple test data", e)
            throw e // Rethrow to handle the error further up if needed
        }
    }




}