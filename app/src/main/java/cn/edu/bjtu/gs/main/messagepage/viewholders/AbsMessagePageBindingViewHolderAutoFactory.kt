package cn.edu.bjtu.gs.main.messagepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageFragment
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import cn.edu.bjtu.gs.main.messagepage.MessagePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.AbsStrategyBaseIntBindingAutoFactory

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:29
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsMessagePageBindingViewHolderAutoFactory<VH : AbsMessagePageBindingBaseViewHolder, VB : ViewBinding> :
    AbsStrategyBaseIntBindingAutoFactory<VH, VB, MessagePageViewModel, MessagePageModel>(
        MessagePageFragment.factoryBindingMapPool
    ) {
}