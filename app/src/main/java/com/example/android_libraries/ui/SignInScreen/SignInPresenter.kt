package com.example.android_libraries.ui.SignInScreen

import android.os.Handler
import android.os.Looper
import com.example.android_libraries.domain.SignInApi


const val RESULT_OK = 1
const val DELAY = 2_000L

class SignInPresenter(val api: SignInApi) : SignInContract.Presenter {
    private lateinit var view: SignInContract.View
    private val handler by lazy { Handler(Looper.getMainLooper()) }
    private var isRestored = false

    override fun onAttach(view: SignInContract.View) {
        this.view = view
        if (isRestored) {
            view.setSuccess()
        }
    }

    override fun onConfirm(login: String, password: String) {
        if (login.isNotEmpty() and password.isNotEmpty()) {
            view.setProgressView(true)
            handler.postDelayed({
                view.setProgressView(false)
                if (api.checkResult() == RESULT_OK) {
                    view.setSuccess()
                } else {
                    view.setFailure()
                }
            }, DELAY)
        } else {
            view.isFormFilled()
        }
    }
}