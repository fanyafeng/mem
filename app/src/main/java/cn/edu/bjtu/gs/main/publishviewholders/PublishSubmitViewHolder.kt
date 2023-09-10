package cn.edu.bjtu.gs.main.publishviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.ItemPublishSubmitLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder
import com.ripple.tool.kttypelians.SuccessLambda

/**
 * Author: fanyafeng
 * Date: 2023/8/25 15:18
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishSubmitViewHolder(
    val binding: ItemPublishSubmitLayoutBinding,
    val lambda: SuccessLambda<String>
) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.title?.let {
            binding.tvSubmit.text = it
        }
        binding.tvSubmit.setOnClickListener {
            lambda?.invoke("")
        }
    }

    class Factory(private val lambda: SuccessLambda<String>) :
        AbsPublishBindingViewHolderAutoFactory<PublishSubmitViewHolder, ItemPublishSubmitLayoutBinding>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): StrategyBaseBindingViewHolder<PublishViewModel, PublishModel> {
            return PublishSubmitViewHolder(
                ItemPublishSubmitLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                ), lambda
            )
        }


        override fun getPoolableType(): Int {
            return PUBLISH_SUBMIT
        }
    }
}