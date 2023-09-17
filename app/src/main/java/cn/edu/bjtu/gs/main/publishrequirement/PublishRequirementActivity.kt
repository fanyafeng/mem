package cn.edu.bjtu.gs.main.publishrequirement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.databinding.ActivityPublishRequirementBinding
import cn.edu.bjtu.gs.main.publishviewholders.AbsPublishBindingBaseViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishAdapter
import cn.edu.bjtu.gs.main.publishviewholders.PublishChooseTimeViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishChooseViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishEmptyViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishImageViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishInputWithTitleViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishSubmitViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishTitleViewHolder
import cn.edu.bjtu.gs.main.publishviewholders.PublishViewModel
import cn.edu.bjtu.gs.main.publishviewholders.api.PublishEditPostParams
import cn.edu.bjtu.gs.main.publishviewholders.api.PublishEditResponse
import cn.edu.bjtu.gs.url.Urls
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpPost
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

class PublishRequirementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublishRequirementBinding
    private val viewModel by viewModels<PublishViewModel>()
    private val adapter = PublishAdapter()
    private var targetList = mutableListOf<PublishModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishRequirementBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }

        StrategyWithPriorityIntBindingLinkedMap<PublishViewModel, PublishModel>().apply {
            register(PublishEmptyViewHolder.Factory::class.java)
            put(PublishInputWithTitleViewHolder.Factory(lambda = {

            }))
            put(PublishInputViewHolder.Factory(lambda = {

            }))
            put(PublishChooseViewHolder.Factory(lambda = {

            }))
            register(PublishTitleViewHolder.Factory::class.java)
            register(PublishImageViewHolder.Factory::class.java)
            register(PublishChooseTimeViewHolder.Factory::class.java)
            put(PublishSubmitViewHolder.Factory(lambda = {
                postData()
            }))
        }
    }

    private fun initData() {
        binding.rvRequirement.adapter = adapter
        binding.rvRequirement.layoutManager = LinearLayoutManager(this)
        val list = mutableListOf<PublishModel>().apply {
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE).apply {
                title = "需求名称"
                hintTitle = "不超过30个字符"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "需求类型"
                url = Urls.BASE_URL + Urls.URL_DEMAND
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_INPUT_WITH_TITLE).apply {
                title = "需要人数"
                hintTitle = "请输入需要人数"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_TIME).apply {
                title = "截止时间"

            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_CHOOSE).apply {
                title = "关联标签"
            })
            add(PublishModel(AbsPublishBindingBaseViewHolder.PUBLISH_TITLE).apply {
                title = "需求描述"
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
        this.targetList = list
        adapter.submitList(list)
    }

    private fun postData() {
//        var canPostData = true
//        targetList.forEach {
//            if (it.result.isNullOrEmpty()) {
//                canPostData = false
//                showToast(
//                    it.title + "不能为空"
//                )
//                return@forEach
//            }
//        }
//        if (!canPostData) {
//            return
//        }


        httpPost {
            val fromParam = PublishEditPostParams()
            fromParam.title = targetList[0].result ?: ""
            fromParam.type = targetList[1].result ?: ""
            fromParam.startTime = targetList[2].result ?: ""
            fromParam.endTime = targetList[3].result ?: ""
            fromParam.address = targetList[4].result ?: ""
            fromParam.volume = targetList[5].result ?: ""
            fromParam.enrollStartTime = targetList[6].result ?: ""
            fromParam.enrollEndTime = targetList[7].result ?: ""
            fromParam.cancelEndTime = targetList[8].result ?: ""
            fromParam.tag = targetList[9].result ?: ""
            fromParam.content = targetList[10].result ?: ""

            params = fromParam

            onSuccess<PublishEditResponse> {
                showToast("发布成功")
                finish()
            }

            onFailed {
                showToast(it.message ?: "未知错误")
            }

        }
    }

    companion object {
        val pool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<PublishViewModel, PublishModel>>()
    }
}