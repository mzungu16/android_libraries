package com.example.android_libraries.ui.SignInScreen


import com.example.android_libraries.domain.SignInUsecase

const val RESULT_OK = 1

class SignInPresenter(private val signInUsecase: SignInUsecase) : SignInContract.Presenter {
    private lateinit var view: SignInContract.View
    private var isRestored = false

    override fun onAttach(view: SignInContract.View) {
        this.view = view
        if (isRestored) {
            view.setSuccess()
        }
    }

    override fun onConfirm(login: String, password: String) {
        if (login.isNotEmpty() and password.isNotEmpty()) {
            signInUsecase.checkResult()
            if (signInUsecase.getValue() == RESULT_OK) {
                view.setSuccess()
                isRestored = true
            } else {
                view.setFailure()
            }
        } else {
            view.isFormFilled()
        }
    }
}