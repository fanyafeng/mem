package cn.edu.bjtu.gs.main.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.ActivityAnnotation
import cn.edu.bjtu.gs.databinding.ActivityRegisterBinding


@ActivityAnnotation(false)
class RegisterActivity : BaseActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {

    }
}