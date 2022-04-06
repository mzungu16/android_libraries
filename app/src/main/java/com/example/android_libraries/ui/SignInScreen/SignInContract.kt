package com.example.android_libraries.ui.SignInScreen

class SignInContract {
    interface View {
        fun setSuccess()
        fun setFailure()
        fun setProgressView(visible: Boolean)
        fun isFormFilled()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onConfirm(login: String, password: String)
    }

    interface Model {
        fun internetAccess(): Int
    }
}