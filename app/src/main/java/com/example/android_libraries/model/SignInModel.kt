package com.example.android_libraries.model

import com.example.android_libraries.ui.SignInScreen.SignInContract

class SignInModel : SignInContract.Model {
    private val range = 0..2
    override fun internetAccess(): Int {
        return (range).random()
    }
}