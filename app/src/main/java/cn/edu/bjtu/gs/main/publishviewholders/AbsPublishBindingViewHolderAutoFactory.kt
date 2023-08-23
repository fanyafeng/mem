package cn.edu.bjtu.gs.main.publishviewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.publishactivity.PublishActivity
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.AbsStrategyBaseIntBindingAutoFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import java.util.concurrent.ConcurrentHashMap

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:21
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsPublishBindingViewHolderAutoFactory<VH : AbsPublishBindingBaseViewHolder, VB : ViewBinding>(
) :
    AbsStrategyBaseIntBindingAutoFactory<VH, VB, PublishViewModel, PublishModel>(pool) {

    companion object {
        val pool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<PublishViewModel, PublishModel>>()
    }
}