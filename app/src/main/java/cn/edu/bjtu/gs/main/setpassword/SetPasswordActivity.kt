package cn.edu.bjtu.gs.main.setpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivitySetPasswordBinding

class SetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetPasswordBinding

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
}