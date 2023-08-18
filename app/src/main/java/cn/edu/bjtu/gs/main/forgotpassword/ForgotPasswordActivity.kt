package cn.edu.bjtu.gs.main.forgotpassword

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityForgotPasswordBinding
import cn.edu.bjtu.gs.main.register.api.SendPhoneCodePostParam
import cn.edu.bjtu.gs.main.register.api.SendPhoneResponse
import cn.edu.bjtu.gs.main.setpassword.SetPasswordActivity
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpGet

@UserStatusSettingAnnotation(false)
class ForgotPasswordActivity : BaseActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()
    private var uuid: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.sendCode.setOnClickListener { sendCode() }
    }

    private fun initData() {
        binding.login.setOnClickListener { verifyCode() }
    }

    private fun verifyCode() {
        if (binding.loginPasswordInput.text.toString().trim().isNullOrEmpty()) {
            showToast("请输入验证码")
            return
        }
        if (binding.loginPasswordInput.text.toString().trim() == uuid) {
            startActivity(Intent(this, SetPasswordActivity::class.java))
        }
    }

    private fun sendCode() {
        if (binding.loginNumInput.text.toString().trim().isNullOrEmpty()) {
            showToast("请输入手机号")
            return
        }
        httpGet {
            val fromParam = SendPhoneCodePostParam()
            fromParam.phone = binding.loginNumInput.text.toString().trim()
            params = fromParam

            onSuccess<SendPhoneResponse> {
                uuid = it.uuid
            }

            onFailed {
                showToast(it.message ?: "")
            }
        }
    }
}