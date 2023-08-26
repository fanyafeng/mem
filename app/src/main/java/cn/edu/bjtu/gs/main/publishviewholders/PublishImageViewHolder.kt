package cn.edu.bjtu.gs.main.publishviewholders

import cn.edu.bjtu.gs.databinding.ItemPublishImageLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/26 14:21
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishImageViewHolder(val binding: ItemPublishImageLayoutBinding) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.title?.let {
            binding.tvTitle.text = it
        }
    }

    @ViewHolderIntAnnotation(PUBLISH_IMAGE)
    class Factory :
        AbsPublishBindingViewHolderAutoFactory<PublishImageViewHolder, ItemPublishImageLayoutBinding>()
}