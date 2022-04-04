package com.example.android_libraries.contracts

class SignInContract {
    interface View {
        fun setSuccess()
        fun setFailure()
        fun isFormFilled()
    }

    interface Presenter{
        fun onAttach(view:View)
        fun onPressed(login:String,password:String)
    }

    interface Model{
        fun internetAccess():Int
    }
}