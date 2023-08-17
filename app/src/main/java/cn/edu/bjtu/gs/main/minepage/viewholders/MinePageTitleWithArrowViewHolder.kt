package cn.edu.bjtu.gs.main.minepage.viewholders

import android.content.Intent
import cn.edu.bjtu.gs.databinding.MinePageTitleWithArrowLayoutBinding
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


class MinePageTitleWithArrowViewHolder(val binding: MinePageTitleWithArrowLayoutBinding) :
    AbsMinePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: MinePageViewModel?,
        dataSource: MinePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.let {
            if (!it.title.isNullOrEmpty()) {
                binding.tvTitle.text = it.title
            }
            if (!it.subTitle.isNullOrEmpty()) {
                binding.tvContent.text = it.subTitle
            }
            binding.root.setOnClickListener { _ ->
                mContext?.let { context ->
                    if (it.clazz == null) return@setOnClickListener
                    context.startActivity(Intent(context, it.clazz))
                }
            }
        }

    }

    @ViewHolderIntAnnotation(TOP_TITLE_WITH_ARROW)
    class Factory :
        AbsMinePageBindingViewHolderAutoFactory<MinePageTitleWithArrowViewHolder, MinePageTitleWithArrowLayoutBinding>()
}