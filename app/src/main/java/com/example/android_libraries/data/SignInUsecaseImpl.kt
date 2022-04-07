package com.example.android_libraries.data

import com.example.android_libraries.domain.SignInApi
import com.example.android_libraries.domain.SignInUsecase

class SignInUsecaseImpl(private val api: SignInApi) : SignInUsecase {
    override fun checkResult(): Int {
        return api.checkResult()
    }
}