package cn.edu.bjtu.gs.main.homepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:41
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsHomePageBindingBaseViewHolder(binding: ViewBinding) :
    StrategyBaseBindingViewHolder<HomePageViewModel, HomePageModel>(binding) {
    companion object {
        const val EMPTY = -1
        const val TOP_HEADER = 0
        const val TOP_ACTIVITY = 1
        const val TOP_ACTIVITY_HEADER = 2
    }
}