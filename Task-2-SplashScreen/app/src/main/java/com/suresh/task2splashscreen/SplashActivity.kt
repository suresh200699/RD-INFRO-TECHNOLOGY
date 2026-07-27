package com.suresh.task2splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.suresh.task2splashscreen.onboarding.OnBoardingActivity
import com.suresh.task2splashscreen.utils.PrefManager

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val prefManager = PrefManager(this)

            if (true) {
                startActivity(Intent(this, OnBoardingActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish()

        }, 2500)
    }
}