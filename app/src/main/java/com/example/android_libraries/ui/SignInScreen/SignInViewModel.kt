package com.example.android_libraries.ui.SignInScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android_libraries.data.MockSignInImpl


class SignInViewModel() : ViewModel(), SignInContract.ViewModel {
    private val liveDataToObserve: MutableLiveData<Int> = MutableLiveData()
    private val api = MockSignInImpl()

    override fun getLiveData(): LiveData<Int> {
        return Transformations.switchMap(liveDataToObserve) {
            api.getLiveData()
        }
    }

    override fun setValue() {
        liveDataToObserve.value = getLiveData().value
    }

    override fun getAccess() {
        api.setLiveDataValue()
    }
}