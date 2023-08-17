package cn.edu.bjtu.gs.main.homepage.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.CustomEmptyViewHolderLayoutBinding
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageEmptyViewHolder
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:52
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageEmptyViewHolder(binding: CustomEmptyViewHolderLayoutBinding) :
    AbsHomePageBindingBaseViewHolder(binding) {
    override fun bindData(
        viewModel: HomePageViewModel?,
        dataSource: HomePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
    }

    companion object {
        fun getSample(parent: ViewGroup, viewType: Int) = HomePageEmptyViewHolder(
            CustomEmptyViewHolderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @ViewHolderIntAnnotation(EMPTY)
    class Factory() :
        AbsHomePageBindingViewHolderAutoFactory<HomePageEmptyViewHolder, CustomEmptyViewHolderLayoutBinding>()
}