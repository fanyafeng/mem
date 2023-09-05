package cn.edu.bjtu.gs.main.homepage.viewholders

import cn.edu.bjtu.gs.databinding.ItemHomePageActivityLayoutBinding
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:50
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageActivityViewHolder(val binding: ItemHomePageActivityLayoutBinding) :
    AbsHomePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: HomePageViewModel?,
        dataSource: HomePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
        binding.activityTitle.text = dataSource?.title ?: ""
        binding.activityDesc.text = dataSource?.content ?: ""
    }

    @ViewHolderIntAnnotation(TOP_ACTIVITY)
    class Factory() :
        AbsHomePageBindingViewHolderAutoFactory<HomePageActivityViewHolder, ItemHomePageActivityLayoutBinding>()

}