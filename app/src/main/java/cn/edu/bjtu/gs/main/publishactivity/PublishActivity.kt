package cn.edu.bjtu.gs.main.publishactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityPublishBinding

@UserStatusSettingAnnotation(true)
class PublishActivity : BaseActivity() {

    private lateinit var binding: ActivityPublishBinding
    private val viewModel by viewModels<PublishViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
    }
}