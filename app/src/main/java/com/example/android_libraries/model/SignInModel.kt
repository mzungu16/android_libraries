package com.example.android_libraries.model

import com.example.android_libraries.contracts.SignInContract

class SignInModel : SignInContract.Model {
    private val range = 0..3
    override fun internetAccess(): Int {
        return (range).random()
    }
}