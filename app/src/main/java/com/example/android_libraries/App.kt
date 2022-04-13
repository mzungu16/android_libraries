package com.example.android_libraries

import android.app.Application
import android.content.Context
import com.example.android_libraries.data.MockSignInImpl

class App : Application() {
    val api by lazy { MockSignInImpl() }
//    val signInUsecase by lazy { SignInUsecaseImpl(api, Handler(Looper.getMainLooper())) }
}

val Context.app: App
    get() {
        return applicationContext as App
    }