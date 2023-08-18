package cn.edu.bjtu.gs.main.messagepage.viewholders

import cn.edu.bjtu.gs.databinding.ItemMessagePageTopLayoutBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import cn.edu.bjtu.gs.main.messagepage.MessagePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:47
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MessagePageTopViewHolder(val binding: ItemMessagePageTopLayoutBinding) :
    AbsMessagePageBindingBaseViewHolder(binding) {
    override fun bindData(
        viewModel: MessagePageViewModel?,
        dataSource: MessagePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
    }

    @ViewHolderIntAnnotation(TOP_HEADER)
    class Factory :
        AbsMessagePageBindingViewHolderAutoFactory<MessagePageTopViewHolder, ItemMessagePageTopLayoutBinding>()
}