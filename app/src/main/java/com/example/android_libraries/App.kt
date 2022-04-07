package com.example.android_libraries

import android.app.Application
import android.content.Context
import com.example.android_libraries.data.MockSignInImpl
import com.example.android_libraries.data.SignInUsecaseImpl

class App : Application() {
    private val api by lazy { MockSignInImpl() }
    val signInUsecase by lazy { SignInUsecaseImpl(api) }
}

val Context.app: App
    get() {
        return applicationContext as App
    }