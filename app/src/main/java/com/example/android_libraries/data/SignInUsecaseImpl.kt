package com.example.android_libraries.data

import android.os.Handler
import com.example.android_libraries.domain.SignInApi
import com.example.android_libraries.domain.SignInUsecase


class SignInUsecaseImpl(
    private val api: SignInApi,
    private val handler: Handler
) : SignInUsecase {
    override fun checkResult(callback: (Int) -> Unit) {
        Thread {
            handler.postDelayed({
                callback(api.checkResult())
            }, 2000)
        }.start()
    }
}