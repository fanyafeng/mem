package cn.edu.bjtu.gs.main.publishviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.edu.bjtu.gs.databinding.ItemPublishInputWithTitleLayoutBinding
import cn.edu.bjtu.gs.databinding.ItemPublishSubmitLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder
import com.ripple.tool.kttypelians.SuccessLambda
import java.util.concurrent.ConcurrentHashMap

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:27
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishInputWithTitleViewHolder(
    binding: ItemPublishInputWithTitleLayoutBinding,
    val lambda: SuccessLambda<String>
) :
    AbsPublishBindingBaseViewHolder(binding) {

    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
    }

    class Factory(private val lambda: SuccessLambda<String>) :
        AbsPublishBindingViewHolderAutoFactory<PublishInputWithTitleViewHolder, ItemPublishInputWithTitleLayoutBinding>(
        ) {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): StrategyBaseBindingViewHolder<PublishViewModel, PublishModel> {
            return PublishInputWithTitleViewHolder(
                ItemPublishInputWithTitleLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                ), lambda
            )
        }

        override fun getPoolableType(): Int {
            return PUBLISH_INPUT_WITH_TITLE
        }
    }
}