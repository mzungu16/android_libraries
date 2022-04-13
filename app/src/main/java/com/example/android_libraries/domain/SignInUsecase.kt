package com.example.android_libraries.domain



interface SignInUsecase {
    fun checkResult(callback:(Int) -> Unit)
}