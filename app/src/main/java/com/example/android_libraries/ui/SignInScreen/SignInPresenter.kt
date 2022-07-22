package com.example.android_libraries.ui.SignInScreen

import com.example.android_libraries.domain.SignInUsecase

const val RESULT_OK = 1

class SignInPresenter(private val signInUsecase: SignInUsecase) : SignInContract.Presenter {
    private lateinit var view: SignInContract.View
    var isRestored = false

    override fun onAttach(view: SignInContract.View) {
        this.view = view
        if (isRestored) {
            view.setSuccess()
        }
    }

    override fun onConfirm(login: String, password: String) {
        val value = checkMethod(login,password)
        if (value) {
            view.setProgressView(true)
            signInUsecase.checkResult {
                if (it == RESULT_OK) {
                    view.setProgressView(false)
                    view.setSuccess()
                    isRestored = true
                } else {
                    view.setProgressView(false)
                    view.setFailure()
                }
            }
        } else {
            view.isFormFilled()
        }
    }
    fun checkMethod(login: String,password: String) : Boolean{
        return login.isNotEmpty() and password.isNotEmpty()
    }
}