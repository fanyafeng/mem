package cn.edu.bjtu.gs.main.publishviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.CustomEmptyViewHolderLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/23 17:28
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishEmptyViewHolder(binding: CustomEmptyViewHolderLayoutBinding) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
    }

    companion object {
        fun getSample(parent: ViewGroup, viewType: Int) = PublishEmptyViewHolder(
            CustomEmptyViewHolderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @ViewHolderIntAnnotation(EMPTY)
    class Factory() :
        AbsPublishBindingViewHolderAutoFactory<PublishEmptyViewHolder, CustomEmptyViewHolderLayoutBinding>(
        )
}