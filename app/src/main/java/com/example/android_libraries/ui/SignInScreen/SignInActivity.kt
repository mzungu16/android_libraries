package com.example.android_libraries.ui.SignInScreen

import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android_libraries.app
import com.example.android_libraries.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        binding.confirmButton.setOnClickListener {
            if (binding.loginEditText.text.toString().isNotEmpty() and
                binding.passwordEditText.text.toString().isNotEmpty()
            ) {
                binding.progressView.visibility = View.VISIBLE
                viewModel.getLiveData().observe(this, Observer {
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (it == 1) {
                            binding.progressView.visibility = View.GONE
                            binding.loginEditText.isEnabled = false
                            binding.passwordEditText.isEnabled = false
                            binding.confirmButton.isEnabled = false
                            Toast.makeText(this, "Вы успешно вошли", Toast.LENGTH_SHORT).show()
                        } else {
                            binding.progressView.visibility = View.GONE
                            Toast.makeText(this, "Неправильно введены данные!", Toast.LENGTH_SHORT)
                                .show()
                            with(binding) {
                                loginEditText.text?.clear()
                                loginEditText.requestFocus()
                                passwordEditText.text?.clear()
                            }
                        }
                    }, 2000)
                })
                viewModel.setValue()
                viewModel.getAccess()
            } else {
                Toast.makeText(this, "Заполните форму целиком!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
/*
* Handler(Looper.getMainLooper()).postDelayed({
                        if (viewModel.checkUser() == 1) {
                            binding.progressView.visibility = View.GONE
                            binding.loginEditText.isEnabled = false
                            binding.passwordEditText.isEnabled = false
                            binding.confirmButton.isEnabled = false
                            Toast.makeText(this, "Вы успешно вошли", Toast.LENGTH_SHORT).show()
                        } else {
                            binding.progressView.visibility = View.GONE
                            Toast.makeText(this, "Неправильно введены данные!", Toast.LENGTH_SHORT)
                                .show()
                            with(binding) {
                                loginEditText.text?.clear()
                                loginEditText.requestFocus()
                                passwordEditText.text?.clear()
                            }
                        }
                    }, 2000)
* */