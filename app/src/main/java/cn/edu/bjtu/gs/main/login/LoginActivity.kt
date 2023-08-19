package cn.edu.bjtu.gs.main.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityLoginBinding
import cn.edu.bjtu.gs.event.LoginEvent
import cn.edu.bjtu.gs.main.forgotpassword.ForgotPasswordActivity
import cn.edu.bjtu.gs.main.login.api.LoginPostParam
import cn.edu.bjtu.gs.main.login.api.LoginResponse
import cn.edu.bjtu.gs.main.register.RegisterActivity
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.greenrobot.eventbus.EventBus

@UserStatusSettingAnnotation(false)
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.registerNumber.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.loginNumInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (!binding.loginNumInput.text.toString().trim()
                        .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                        .isNullOrEmpty()
                ) {
                    binding.login.setBackgroundColor(Color.parseColor("#0052d9"))
                } else {
                    binding.login.setBackgroundColor(Color.parseColor("#bbd3fb"))
                }
            }
        })

        binding.loginPasswordInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (!binding.loginNumInput.text.toString().trim()
                        .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                        .isNullOrEmpty()
                ) {
                    binding.login.setBackgroundColor(Color.parseColor("#0052d9"))
                } else {
                    binding.login.setBackgroundColor(Color.parseColor("#bbd3fb"))
                }
            }

        })

        binding.forgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

    }

    private fun initData() {
        if (!binding.loginNumInput.text.toString().trim()
                .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                .isNullOrEmpty()
        ) {
            binding.login.setOnClickListener {
                httpPost {
                    val fromParams = LoginPostParam()
                    fromParams.username = binding.loginNumInput.text.toString()
                    fromParams.password = binding.loginPasswordInput.text.toString()
                    params = fromParams

                    onStart {
                        showLoadingDialog()
                    }

                    onSuccess<LoginResponse> {
                        it.token?.let { token ->
                            lifecycleScope.launch {
                                viewModel.saveToken(this@LoginActivity, token)
                                launch(Dispatchers.Main) {
                                    delay(300)
                                    dismissLoadingDialog()
                                    showToast("登录成功")
                                    EventBus.getDefault().post(LoginEvent())
                                    finish()
                                }
                            }
                        }
                    }

                    onFailed {
                        showToast(it.message ?: "")
                    }

                    onFinish {

                    }
                }
            }
        }

    }
}