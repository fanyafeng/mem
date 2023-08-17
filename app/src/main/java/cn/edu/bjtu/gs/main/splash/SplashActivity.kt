package cn.edu.bjtu.gs.main.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivitySplashBinding
import cn.edu.bjtu.gs.main.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {
        Handler().postDelayed({
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }, 2000)
    }
}