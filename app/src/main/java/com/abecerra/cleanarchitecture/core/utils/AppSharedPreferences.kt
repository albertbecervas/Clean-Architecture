package com.abecerra.cleanarchitecture.core.utils

import android.content.SharedPreferences
import com.abecerra.cleanarchitecture.core.App
import javax.inject.Singleton

@Singleton
class AppSharedPreferences {

    private val mPrefs: SharedPreferences = App.getAppContext().getSharedPreferences(MY_PREFS, 0)

    companion object {

        const val MY_PREFS: String = "MY_PREFS"
        const val TEST_PREFS: String = "test"

        private var INSTANCE: AppSharedPreferences? = null

        fun getInstance(): AppSharedPreferences {
            if (INSTANCE == null) INSTANCE = AppSharedPreferences()
            return INSTANCE!!
        }
    }

    fun setTestPreference(test: String) {
        mPrefs.edit()
            .putString(TEST_PREFS, test)
            .apply()
    }

    fun getTestPreference(): String {
        return mPrefs.getString(TEST_PREFS, "") ?: ""
    }

}