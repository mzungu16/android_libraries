package com.example.android_libraries.data

import com.example.android_libraries.domain.SignInApi

class MockSignInImpl : SignInApi {
    override fun checkResult(): Int {
        val range = 0..2
        return range.random()
    }
}