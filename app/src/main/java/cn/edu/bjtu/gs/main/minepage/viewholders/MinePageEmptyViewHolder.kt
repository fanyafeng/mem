package cn.edu.bjtu.gs.main.minepage.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.CustomEmptyViewHolderLayoutBinding
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/11 16:43
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MinePageEmptyViewHolder(binding: CustomEmptyViewHolderLayoutBinding) :
    AbsMinePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: MinePageViewModel?,
        dataSource: MinePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
    }

    companion object {
        fun getSample(parent: ViewGroup, viewType: Int) = MinePageEmptyViewHolder(
            CustomEmptyViewHolderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @ViewHolderIntAnnotation(EMPTY)
    class Factory :
        AbsMinePageBindingViewHolderAutoFactory<MinePageEmptyViewHolder, CustomEmptyViewHolderLayoutBinding>()
}