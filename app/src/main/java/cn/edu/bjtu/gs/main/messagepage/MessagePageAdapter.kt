package cn.edu.bjtu.gs.main.messagepage

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.main.messagepage.viewholders.MessagePageEmptyViewHolder
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:52
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MessagePageAdapter :
    ListAdapter<MessagePageModel, StrategyBaseBindingViewHolder<MessagePageViewModel, MessagePageModel>>(
        COMPARATOR
    ) {

    var viewModel: MessagePageViewModel? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StrategyBaseBindingViewHolder<MessagePageViewModel, MessagePageModel> {
        return MessagePageFragment.factoryBindingMapPool[viewType]?.onCreateViewHolder(
            parent,
            viewType
        ) ?: MessagePageEmptyViewHolder.getSample(parent, viewType)
    }

    override fun onBindViewHolder(
        holder: StrategyBaseBindingViewHolder<MessagePageViewModel, MessagePageModel>,
        position: Int
    ) {
        val model = getItem(position)
        holder.bindData(viewModel, model, position)
    }

    override fun getItemViewType(position: Int): Int {
        val model = getItem(position)
        return model.getType()
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<MessagePageModel>() {
            override fun areItemsTheSame(
                oldItem: MessagePageModel, newItem: MessagePageModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MessagePageModel, newItem: MessagePageModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}