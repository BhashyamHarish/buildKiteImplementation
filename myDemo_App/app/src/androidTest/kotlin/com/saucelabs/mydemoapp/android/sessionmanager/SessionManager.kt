package com.saucelabs.mydemoapp.android.sessionmanager

import android.content.Context

import com.saucelabs.mydemoapp.android.utils.SingletonClass

class SessionManager(context1: Context) {

    private var context:Context=context1
    companion object {
        private const val PREFS_NAME = "test_prefs"
        private const val AUTH_TOKEN_KEY = "auth_token"
    }
    fun setupSession(authToken: String) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(AUTH_TOKEN_KEY, authToken).apply()
    }

    fun clearSession() {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }

    fun isSessionActive(): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.contains(AUTH_TOKEN_KEY)
    }
}

