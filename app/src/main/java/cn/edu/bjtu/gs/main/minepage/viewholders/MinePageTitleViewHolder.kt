package cn.edu.bjtu.gs.main.minepage.viewholders

import cn.edu.bjtu.gs.databinding.MinePageTitleLayoutBinding
import cn.edu.bjtu.gs.databinding.MinePageTopHeaderLayoutBinding
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/11 11:08
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MinePageTitleViewHolder(val binding: MinePageTitleLayoutBinding) :
    AbsMinePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: MinePageViewModel?,
        dataSource: MinePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)


    }

    @ViewHolderIntAnnotation(TOP_TITLE)
    class Factory :
        AbsMinePageBindingViewHolderAutoFactory<MinePageTitleViewHolder, MinePageTitleLayoutBinding>()
}