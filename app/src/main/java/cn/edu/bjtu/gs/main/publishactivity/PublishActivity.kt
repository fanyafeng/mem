package cn.edu.bjtu.gs.main.publishactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityPublishBinding
import cn.edu.bjtu.gs.main.publishviewholders.AbsPublishBindingBaseViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishAdapter
import cn.edu.bjtu.gs.main.publishviewholders.PublishChooseViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishEmptyViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputWithTitleViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishSubmitViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

@UserStatusSettingAnnotation(true)
class PublishActivity : BaseActivity() {

    private lateinit var binding: ActivityPublishBinding
    private val viewModel by viewModels<PublishViewModel>()
    private val adapter = PublishAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
    }

    private fun initView() {
        StrategyWithPriorityIntBindingLinkedMap<PublishViewModel, PublishModel>().apply {
            register(PublishEmptyViewHolder.Factory::class.java)
            put(PublishInputWithTitleViewHolder.Factory(lambda = {

            }))
            put(PublishInputViewHolder.Factory(lambda = {

            }))
            put(PublishChooseViewHolder.Factory(lambda = {

            }))
            put(PublishSubmitViewHolder.Factory(lambda = {

            }))
        }



        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
        binding.rvActivity.adapter = adapter
        binding.rvActivity.layoutManager = LinearLayoutManager(this)
        val list = mutableListOf<PublishModel>().apply {
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE))
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT))
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE))
        }
        adapter.submitList(list)
    }


}