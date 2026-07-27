package com.suresh.task2splashscreen.utils

import android.content.Context

class PrefManager(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        sharedPreferences.edit().putBoolean("first_time", isFirstTime).apply()
    }

    fun isFirstTimeLaunch(): Boolean {
        return sharedPreferences.getBoolean("first_time", true)
    }
}