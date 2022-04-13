package com.example.android_libraries.ui.SignInScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android_libraries.data.MockSignInImpl
import com.example.android_libraries.domain.SignInApi
import com.example.android_libraries.domain.SignInUsecase
import com.example.android_libraries.utils.Subscriber

class SignInViewModel() : ViewModel() {
    private val liveDataToObserve: MutableLiveData<Int> = MutableLiveData()
    private val api = MockSignInImpl()

    fun getLiveData(): LiveData<Int> {
        return Transformations.switchMap(liveDataToObserve) {
            api.getLiveData()
        }
    }
    fun setValue() {
        liveDataToObserve.value = getLiveData().value
    }

    fun getAccess() {
        api.setLiveDataValue()
    }
}