package cn.edu.bjtu.gs.main.taglistpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivityTagListBinding

class TagListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTagListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTagListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView(){

    }

    private fun initData(){

    }
}