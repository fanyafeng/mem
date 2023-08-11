package cn.edu.bjtu.gs.main.minepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.minepage.MinePageFragment
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.AbsStrategyBaseIntBindingAutoFactory

/**
 * Author: fanyafeng
 * Date: 2023/8/11 11:06
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsMinePageBindingViewHolderAutoFactory<VH : AbsMinePageBindingBaseViewHolder, VB : ViewBinding> :
    AbsStrategyBaseIntBindingAutoFactory<VH, VB, MinePageViewModel, MinePageModel>(MinePageFragment.factoryBindingMapPool) {
}