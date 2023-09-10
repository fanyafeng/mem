package cn.edu.bjtu.gs.main.publishviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.ItemPublishChooseWithTitleLayoutBinding
import cn.edu.bjtu.gs.databinding.ItemPublishInputWithTitleLayoutBinding
import cn.edu.bjtu.gs.main.dialog.industrydialog.IndustryDialog
import cn.edu.bjtu.gs.url.Urls
import com.ripple.log.tpyeextend.toLogD
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder
import com.ripple.tool.kttypelians.SuccessLambda

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:34
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishChooseViewHolder(
    val binding: ItemPublishChooseWithTitleLayoutBinding,
    val lambda: SuccessLambda<String>
) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.title?.let {
            binding.tvTitle.text = it
        }
        dataSource?.hintTitle?.let {
            binding.etContent.text = it
        }

        binding.root.setOnClickListener {
            val dialog = IndustryDialog()
            dialog.showIndustryDialog(binding.root.context, dataSource?.url) {
                it.dictLabel.toLogD()
                binding.etContent.text = it.dictLabel
                dataSource?.result = it.dictLabel
            }

        }
    }

    class Factory(private val lambda: SuccessLambda<String>) :
        AbsPublishBindingViewHolderAutoFactory<PublishChooseViewHolder, ItemPublishChooseWithTitleLayoutBinding>(
        ) {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): StrategyBaseBindingViewHolder<PublishViewModel, PublishModel> {
            return PublishChooseViewHolder(
                ItemPublishChooseWithTitleLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                ), lambda
            )
        }

        override fun getPoolableType(): Int {
            return PUBLISH_CHOOSE
        }
    }

}