package com.example.android_libraries.ui.SignInScreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_libraries.app
import com.example.android_libraries.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), SignInContract.View {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = checkPresenter()
        presenter.onAttach(this)
        with(binding) {
            confirmButton.setOnClickListener {
                presenter.onConfirm(loginEditText.text.toString(), passwordEditText.text.toString())
            }
        }
    }

    private fun checkPresenter(): SignInPresenter {
        val presenter = lastCustomNonConfigurationInstance as? SignInPresenter
        return presenter ?: SignInPresenter(app.api)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
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

    override fun setProgressView(visible: Boolean) {
        when (visible) {
            false -> binding.progressView.visibility = View.GONE
            true -> binding.progressView.visibility = View.VISIBLE
        }
    }

    override fun isFormFilled() {
        Toast.makeText(this, "Заполните форму целиком!", Toast.LENGTH_SHORT).show()
    }
}