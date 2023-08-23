package cn.edu.bjtu.gs.main.publishactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityPublishBinding
import cn.edu.bjtu.gs.main.publishviewholders.PublishChooseViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputWithTitleViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

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
        StrategyWithPriorityIntBindingLinkedMap<PublishViewModel, PublishModel>().apply {
            register(PublishInputWithTitleViewHolder.Factory()::class.java)
            register(PublishInputViewHolder.Factory()::class.java)
            register(PublishChooseViewHolder.Factory()::class.java)
        }



        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
    }


}