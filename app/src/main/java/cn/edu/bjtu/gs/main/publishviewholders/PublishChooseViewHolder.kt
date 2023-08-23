package cn.edu.bjtu.gs.main.publishviewholders

import cn.edu.bjtu.gs.databinding.ItemPublishChooseWithTitleLayoutBinding
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import java.util.concurrent.ConcurrentHashMap

/**
 * Author: fanyafeng
 * Date: 2023/8/23 16:34
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishChooseViewHolder(binding: ItemPublishChooseWithTitleLayoutBinding) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
    }

    @ViewHolderIntAnnotation(PUBLISH_CHOOSE)
    class Factory() :
        AbsPublishBindingViewHolderAutoFactory<PublishChooseViewHolder, ItemPublishChooseWithTitleLayoutBinding>(
        )

}