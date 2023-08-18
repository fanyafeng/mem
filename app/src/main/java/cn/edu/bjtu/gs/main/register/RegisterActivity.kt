package cn.edu.bjtu.gs.main.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.ActivityAnnotation
import cn.edu.bjtu.gs.databinding.ActivityRegisterBinding
import cn.edu.bjtu.gs.main.login.LoginActivity
import cn.edu.bjtu.gs.main.register.api.RegisterPostParam
import cn.edu.bjtu.gs.main.register.api.RegisterResponse
import cn.edu.bjtu.gs.main.register.api.SendPhoneCodePostParam
import cn.edu.bjtu.gs.main.register.api.SendPhoneResponse
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpGet
import com.ripple.http.extend.httpPost


@ActivityAnnotation(false)
class RegisterActivity : BaseActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var uuid: String = ""
    private var isFinishSendPhoneCodeRequest = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.sendPhoneCode.setOnClickListener {
            sendPhoneCode()
        }

        binding.register.setOnClickListener {
            registerUser()
        }
    }

    private fun initData() {

    }

    private fun sendPhoneCode() {
        httpGet {
            val fromParam = SendPhoneCodePostParam()
            fromParam.phone = binding.phoneNumInput.text.toString()
            params = fromParam

            onStart {
                isFinishSendPhoneCodeRequest = false
            }

            onSuccess<SendPhoneResponse> {
                uuid = it.uuid
            }

            onFailed {

            }

            onFinish {
                isFinishSendPhoneCodeRequest = true
            }
        }
    }

    private fun registerUser() {
        if (binding.phoneNumInput.text.trim().toString().isNullOrEmpty()) {
            showToast("请输入手机号")
            return
        }
        if (binding.codeNumInput.text.trim().toString().isNullOrEmpty()) {
            showToast("请输入验证码")
            return
        }
        if (binding.passwordInput.text.trim().toString().isNullOrEmpty()) {
            showToast("请输入密码")
            return
        }
        if (binding.passwordInput.text.trim().toString() != binding.passwordAgainInput.text.trim()
                .toString()
        ) {
            showToast("两次密码输入不一致")
            return
        }
        if (uuid.isNullOrEmpty()) {
            showToast("请先获取验证码")
            return
        }
        if (!isFinishSendPhoneCodeRequest) {
            showToast("请等待验证码发送完成")
            return
        }
        httpPost {
            val fromParam = RegisterPostParam()
            fromParam.username = binding.phoneNumInput.text.toString()
            fromParam.code = binding.codeNumInput.text.toString()
            fromParam.password = binding.passwordInput.text.toString()
            fromParam.uuid = uuid
            params = fromParam

            onSuccess<RegisterResponse> {
                showToast("注册成功")
                finish()
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }

            onFailed {
                showToast("注册失败")
            }
        }
    }
}