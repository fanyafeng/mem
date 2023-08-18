package cn.edu.bjtu.gs.main.setpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivitySetPasswordBinding
import cn.edu.bjtu.gs.main.setpassword.api.ForgotPasswordPostParam
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpPost

@UserStatusSettingAnnotation(false)
class SetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetPasswordBinding
    private val viewModel: SetPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {

    }

    private fun setNewPassword(){
        if (binding.loginPasswordInput.text.toString().trim().isNullOrEmpty()) {
            showToast("请输入新密码")
            return
        }
        if (binding.loginPasswordInput.text.toString().trim().length < 6) {
            showToast("密码长度不能小于6位")
            return
        }
        if (binding.loginPasswordInput.text.toString().trim() != binding.loginPasswordInput.text.toString().trim()) {
            showToast("两次密码输入不一致")
            return
        }

        httpPost {
            val fromParam = ForgotPasswordPostParam()
            fromParam.username = ""

        }
    }
}