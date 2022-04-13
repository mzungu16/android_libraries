package com.example.android_libraries.ui.SignInScreen

import androidx.lifecycle.LiveData
interface SignInContract {
    interface ViewModel {
        fun getLiveData():LiveData<Int>
        fun setValue()
        fun getAccess()
    }
}