package cn.edu.bjtu.gs.main.publishviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.ItemPublishInputLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder
import com.ripple.tool.kttypelians.SuccessLambda
import java.util.concurrent.ConcurrentHashMap

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:33
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishInputViewHolder(
    val binding: ItemPublishInputLayoutBinding,
    val lambda: SuccessLambda<String>
) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.hintTitle?.let {
            binding.etContent.hint = it
        }
        dataSource?.result = binding.etContent.text.toString().trim()
    }

    class Factory(private val lambda: SuccessLambda<String>) :
        AbsPublishBindingViewHolderAutoFactory<PublishInputViewHolder, ItemPublishInputLayoutBinding>(
        ) {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): StrategyBaseBindingViewHolder<PublishViewModel, PublishModel> {
            return PublishInputViewHolder(
                ItemPublishInputLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                ), lambda
            )
        }

        override fun getPoolableType(): Int {
            return PUBLISH_INPUT
        }
    }
}