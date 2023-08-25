package cn.edu.bjtu.gs.main.publishviewholders

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/23 17:25
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishAdapter :
    ListAdapter<PublishModel, StrategyBaseBindingViewHolder<PublishViewModel, PublishModel>>(
        COMPARATOR
    ) {

    var viewModel: PublishViewModel? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StrategyBaseBindingViewHolder<PublishViewModel, PublishModel> {
        return AbsPublishBindingViewHolderAutoFactory.pool[viewType]?.onCreateViewHolder(
            parent,
            viewType
        )
            ?: PublishEmptyViewHolder.getSample(parent, viewType)
    }

    override fun onBindViewHolder(
        holder: StrategyBaseBindingViewHolder<PublishViewModel, PublishModel>,
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
        private val COMPARATOR = object : DiffUtil.ItemCallback<PublishModel>() {
            override fun areItemsTheSame(
                oldItem: PublishModel, newItem: PublishModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PublishModel, newItem: PublishModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}