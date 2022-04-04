package com.example.android_libraries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_libraries.R
import com.example.android_libraries.contracts.SignInContract
import com.example.android_libraries.databinding.ActivitySignInBinding
import com.example.android_libraries.presenter.SignInPresenter

class SignInActivity : AppCompatActivity(), SignInContract.View {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = SignInPresenter().also { presenter ->
            presenter.onAttach(this)
        }
        with(binding) {
            confirmButton.setOnClickListener {
                presenter.onPressed(loginEditText.text.toString(), passwordEditText.text.toString())
            }
        }
    }

    override fun setSuccess() {
        Toast.makeText(this, "Вы успешно вошли!", Toast.LENGTH_SHORT).show()
        with(binding) {
            confirmButton.isEnabled = false
            loginEditText.isEnabled = false
            passwordEditText.isEnabled = false
        }

    }

    override fun setFailure() {
        Toast.makeText(this, "Неправильно введены данные!", Toast.LENGTH_SHORT).show()
        with(binding) {
            loginEditText.text?.clear()
            loginEditText.requestFocus()
            passwordEditText.text?.clear()
        }
    }

    override fun isFormFilled() {
        Toast.makeText(this, "Заполните форму целиком!", Toast.LENGTH_SHORT).show()
    }
}