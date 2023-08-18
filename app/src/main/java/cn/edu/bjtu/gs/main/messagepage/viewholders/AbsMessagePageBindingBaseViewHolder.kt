package cn.edu.bjtu.gs.main.messagepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import cn.edu.bjtu.gs.main.messagepage.MessagePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:21
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsMessagePageBindingBaseViewHolder(binding: ViewBinding) :
    StrategyBaseBindingViewHolder<MessagePageViewModel, MessagePageModel>(binding) {
    companion object {
        const val EMPTY = -1
        const val TOP_HEADER = 0
        const val PERSON = 1
        const val TOP_TITLE_WITH_ARROW = 2
    }
}