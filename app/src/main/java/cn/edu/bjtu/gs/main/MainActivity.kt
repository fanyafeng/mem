package cn.edu.bjtu.gs.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivityMainBinding
import cn.edu.bjtu.gs.main.login.api.LoginPostParam
import cn.edu.bjtu.gs.main.register.api.RegisterPostParam
import cn.edu.bjtu.gs.main.register.api.RegisterResponse
import com.ripple.http.extend.httpPost

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.message.text = "首页融合"
        binding.message.setOnClickListener {
//            httpPost {
//                params = RegisterPostParam()
//
//                onSuccess<RegisterResponse> {
//                    Toast.makeText(this@MainActivity, "注册成功", Toast.LENGTH_SHORT).show()
//                }
//
//                onFailed {
//                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
//                }
//            }
        }
    }

    private fun initData() {

    }
}