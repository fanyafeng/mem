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
import cn.edu.bjtu.gs.main.publishviewholders.PublishImageViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputWithTitleViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishSubmitViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishTitleViewHolder
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
            register(PublishTitleViewHolder.Factory::class.java)
            register(PublishImageViewHolder.Factory::class.java)
        }



        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
        binding.rvActivity.adapter = adapter
        binding.rvActivity.layoutManager = LinearLayoutManager(this)
        val list = mutableListOf<PublishModel>().apply {
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE).apply {
                title = "活动名称"
                hintTitle = "不超过30个字符"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "活动类型"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "活动开始\n时间"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "活动结束\n时间"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE).apply {
                title = "活动地点"
                hintTitle = "请输入活动地点"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE).apply {
                title = "活动容量"
                hintTitle = "请输入活动人员限制数量"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "报名开始\n时间"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "报名截止\n时间"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "可取消报名\n截止时间"
                hintTitle = "不选则为报名截止前24小时"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "关联标签"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_TITLE).apply {
                title = "活动内容"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT).apply {
                hintTitle = "请详细描述活动相关细节，如注意事项，限制人员，保证金等"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_IMAGE).apply {
                title = "上传图片"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_SUBMIT).apply {
                title = "发布"
                successLambda = {

                }
            })
        }
        adapter.submitList(list)
    }


}