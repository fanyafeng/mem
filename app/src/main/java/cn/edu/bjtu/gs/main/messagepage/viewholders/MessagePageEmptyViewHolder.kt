package cn.edu.bjtu.gs.main.messagepage.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.CustomEmptyViewHolderLayoutBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import cn.edu.bjtu.gs.main.messagepage.MessagePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:47
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MessagePageEmptyViewHolder(binding: CustomEmptyViewHolderLayoutBinding) :
    AbsMessagePageBindingBaseViewHolder(binding) {
    override fun bindData(
        viewModel: MessagePageViewModel?,
        dataSource: MessagePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
    }

    companion object {
        fun getSample(parent: ViewGroup, viewType: Int) = MessagePageEmptyViewHolder(
            CustomEmptyViewHolderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @ViewHolderIntAnnotation(EMPTY)
    class Factory :
        AbsMessagePageBindingViewHolderAutoFactory<MessagePageEmptyViewHolder, CustomEmptyViewHolderLayoutBinding>()
}