package com.example.android_libraries.presenter

import com.example.android_libraries.contracts.SignInContract
import com.example.android_libraries.model.SignInModel

const val RESULT_OK = 2

class SignInPresenter : SignInContract.Presenter {
    private lateinit var view: SignInContract.View
    private lateinit var model: SignInModel
    override fun onAttach(view: SignInContract.View) {
        this.view = view
        model = SignInModel()
    }

    override fun onPressed(login: String, password: String) {
        if (login.isNotEmpty() and password.isNotEmpty()) {
            if (model.internetAccess() == RESULT_OK) {
                view.setSuccess()
            } else {
                view.setFailure()
            }
        } else {
            view.isFormFilled()
        }
    }
}