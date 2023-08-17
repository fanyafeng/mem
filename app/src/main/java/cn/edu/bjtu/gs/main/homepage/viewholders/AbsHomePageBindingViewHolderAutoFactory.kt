package cn.edu.bjtu.gs.main.homepage.viewholders

import androidx.viewbinding.ViewBinding
import cn.edu.bjtu.gs.main.homepage.HomePageFragment
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.AbsStrategyBaseIntBindingAutoFactory

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:44
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


abstract class AbsHomePageBindingViewHolderAutoFactory<VH : AbsHomePageBindingBaseViewHolder, VB : ViewBinding> :
    AbsStrategyBaseIntBindingAutoFactory<VH, VB, HomePageViewModel, HomePageModel>(HomePageFragment.factoryBindingMapPool) {
}