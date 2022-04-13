package com.example.android_libraries.domain

import androidx.lifecycle.LiveData

interface SignInApi {
    fun getLiveData(): LiveData<Int>
    fun setLiveDataValue()
}