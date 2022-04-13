package com.example.android_libraries.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_libraries.domain.SignInApi
import com.example.android_libraries.utils.Subscriber

class MockSignInImpl{

    private val liveData: MutableLiveData<Int> = MutableLiveData()

    fun getLiveData(): LiveData<Int> = liveData

    fun setLiveDataValue() {
        val range = 0..2
        liveData.value = range.random()
    }
}