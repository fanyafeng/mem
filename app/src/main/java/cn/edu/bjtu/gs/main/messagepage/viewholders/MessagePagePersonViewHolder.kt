package cn.edu.bjtu.gs.main.messagepage.viewholders

import cn.edu.bjtu.gs.databinding.ItemMessagePagePersonLayoutBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import cn.edu.bjtu.gs.main.messagepage.MessagePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:49
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MessagePagePersonViewHolder(val binding: ItemMessagePagePersonLayoutBinding) :
    AbsMessagePageBindingBaseViewHolder(binding) {
    override fun bindData(
        viewModel: MessagePageViewModel?,
        dataSource: MessagePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
    }

    @ViewHolderIntAnnotation(PERSON)
    class Factory :
        AbsMessagePageBindingViewHolderAutoFactory<MessagePagePersonViewHolder, ItemMessagePagePersonLayoutBinding>()
}