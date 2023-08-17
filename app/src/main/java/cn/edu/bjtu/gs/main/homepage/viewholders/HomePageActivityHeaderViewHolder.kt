package cn.edu.bjtu.gs.main.homepage.viewholders

import cn.edu.bjtu.gs.databinding.ItemHomePageActivityHeaderLayoutBinding
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/17 16:00
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageActivityHeaderViewHolder(val binding: ItemHomePageActivityHeaderLayoutBinding) :
    AbsHomePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: HomePageViewModel?,
        dataSource: HomePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)

    }

    @ViewHolderIntAnnotation(TOP_ACTIVITY_HEADER)
    class Factory() :
        AbsHomePageBindingViewHolderAutoFactory<HomePageActivityHeaderViewHolder, ItemHomePageActivityHeaderLayoutBinding>()
}