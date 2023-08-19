package cn.edu.bjtu.gs.main.publishrequirement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivityPublishRequirementBinding

class PublishRequirementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublishRequirementBinding
    private val viewModel by viewModels<PublishRequirementViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishRequirementBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }
    }

    private fun initData() {
    }
}