package cn.edu.bjtu.gs.main.minepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/11 10:56
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsMinePageBindingBaseViewHolder(binding: ViewBinding) :
    StrategyBaseBindingViewHolder<MinePageViewModel, MinePageModel>(binding) {

    companion object {
        const val EMPTY = -1
        const val TOP_HEADER = 0
        const val TOP_TITLE = 1
        const val TOP_TITLE_WITH_ARROW = 2
    }
}