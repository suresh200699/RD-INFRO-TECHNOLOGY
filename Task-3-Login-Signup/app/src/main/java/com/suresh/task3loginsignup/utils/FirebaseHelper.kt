package com.suresh.task3loginsignup.utils

import com.google.firebase.auth.FirebaseAuth

object FirebaseHelper {

    val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

}