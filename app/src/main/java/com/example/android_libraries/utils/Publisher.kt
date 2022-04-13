package com.example.android_libraries.utils

import android.os.Handler

class Publisher<T> {
    private val subscribers = mutableSetOf<T>()
    var value: T? = null
    fun subscribe(handler: Handler, callback: (T?) -> Unit){

    }
}