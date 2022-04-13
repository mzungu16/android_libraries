package com.example.android_libraries.ui.SignInScreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android_libraries.databinding.ActivitySignInBinding

const val EMPTY_ERROR = "Заполните форму целиком!"
const val NOT_FILL_ERROR = "Неправильно введены данные!"
const val SUCCESS = "Вы успешно вошли"
const val RESULT_GOOD = 1
const val DELAY = 2000L

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        val confirmButton = binding.confirmButton
        val loginEditText = binding.loginEditText
        val passwordEditText = binding.passwordEditText
        val progressView = binding.progressView
        val handler = Handler(Looper.getMainLooper())

        confirmButton.setOnClickListener {
            if (isFieldFill(loginEditText, passwordEditText)) {
                progressView.visibility = View.VISIBLE
                viewModel.getLiveData().observe(this) {
                    handler.postDelayed({
                        progressView.visibility = View.GONE
                        if (it == RESULT_GOOD) {
                            loginEditText.isEnabled = false
                            passwordEditText.isEnabled = false
                            confirmButton.isEnabled = false
                            toast(SUCCESS)
                        } else {
                            toast(NOT_FILL_ERROR)
                            loginEditText.text?.clear()
                            loginEditText.requestFocus()
                            passwordEditText.text?.clear()
                        }
                    }, DELAY)
                }
                viewModel.setValue()
                viewModel.getAccess()
            } else {
                toast(EMPTY_ERROR)
            }
        }
    }

    private fun isFieldFill(login: EditText, password: EditText): Boolean {
        return login.text.toString().isNotEmpty() and password.text.toString().isNotEmpty()
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}