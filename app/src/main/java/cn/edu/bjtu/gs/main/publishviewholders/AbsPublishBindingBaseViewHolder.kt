package cn.edu.bjtu.gs.main.publishviewholders

import androidx.viewbinding.ViewBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:16
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsPublishBindingBaseViewHolder(binding: ViewBinding) :
    StrategyBaseBindingViewHolder<PublishViewModel, PublishModel>(binding) {
    companion object {
        const val EMPTY = -1
        const val PUBLISH_INPUT_WITH_TITLE = 0
        const val PUBLISH_INPUT = 1
        const val PUBLISH_CHOOSE = 2
        const val PUBLISH_SUBMIT = 3
        const val PUBLISH_TITLE = 4
        const val PUBLISH_IMAGE = 5
        const val PUBLISH_TIME = 6
    }
}