package cn.edu.bjtu.gs.main.publishrequirement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.databinding.ActivityPublishRequirementBinding
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import java.util.concurrent.ConcurrentHashMap

class PublishRequirementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublishRequirementBinding
    private val viewModel by viewModels<PublishViewModel>()
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

    companion object {
        val pool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<PublishViewModel, PublishModel>>()
    }
}