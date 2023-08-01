package cn.edu.bjtu.gs.main.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView(){

    }

    private fun initData(){

    }
}