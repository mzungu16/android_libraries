package com.example.android_libraries.data

import com.example.android_libraries.domain.SignInApi
import com.example.android_libraries.domain.SignInUsecase


class SignInUsecaseImpl(
    private val api: SignInApi,
) : SignInUsecase {
    var number = 0
    override fun checkResult() {
        Thread {
            Thread.sleep(2000)
            number = api.checkResult()
        }.start()
        Thread.currentThread().join(2000)
    }

    override fun getValue(): Int {
        return number
    }
}