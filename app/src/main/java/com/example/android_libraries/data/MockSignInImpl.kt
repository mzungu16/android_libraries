package com.example.android_libraries.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_libraries.domain.SignInApi

class MockSignInImpl : SignInApi {

    private val liveData: MutableLiveData<Int> = MutableLiveData()

    override fun getLiveData(): LiveData<Int> = liveData

    override fun setLiveDataValue() {
        val range = 0..2
        liveData.value = range.random()
    }
}