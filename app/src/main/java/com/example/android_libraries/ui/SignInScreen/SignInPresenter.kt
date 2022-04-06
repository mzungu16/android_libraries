package com.example.android_libraries.ui.SignInScreen

import android.os.Looper
import com.example.android_libraries.model.SignInModel
import android.os.Handler
import com.example.android_libraries.ui.SignInScreen.SignInContract

const val RESULT_OK = 1
const val DELAY = 2_000L

class SignInPresenter : SignInContract.Presenter {
    private lateinit var view: SignInContract.View
    private lateinit var model: SignInModel
    private val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }
    private var isRestored = false

    override fun onAttach(view: SignInContract.View) {
        this.view = view
        if(isRestored){
            view.setSuccess()
        }
        model = SignInModel()
    }

    override fun onConfirm(login: String, password: String) {
        if (login.isNotEmpty() and password.isNotEmpty()) {
            view.setProgressView(true)
            chekResult()
        } else {
            view.isFormFilled()
        }
    }

    private fun chekResult() {
        handler.postDelayed({
            view.setProgressView(false)
            if (model.internetAccess() == RESULT_OK) {
                view.setSuccess()
                isRestored = true
            } else {
                view.setFailure()
            }
        }, DELAY)
    }
}