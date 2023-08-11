package cn.edu.bjtu.gs.main.minepage

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.main.minepage.viewholders.AbsMinePageBindingBaseViewHolder
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageEmptyViewHolder
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/11 16:37
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MinePageAdapter :
    ListAdapter<MinePageModel, StrategyBaseBindingViewHolder<MinePageViewModel, MinePageModel>>(
        COMPARATOR
    ) {

    var viewModel: MinePageViewModel? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StrategyBaseBindingViewHolder<MinePageViewModel, MinePageModel> {
        return MinePageFragment.factoryBindingMapPool[viewType]?.onCreateViewHolder(
            parent,
            viewType
        )
            ?: MinePageEmptyViewHolder.getSample(parent, viewType)
    }

    override fun onBindViewHolder(
        holder: StrategyBaseBindingViewHolder<MinePageViewModel, MinePageModel>,
        position: Int
    ) {
        val model = getItem(position)
        holder.bindData(viewModel, model, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<MinePageModel>() {
            override fun areItemsTheSame(
                oldItem: MinePageModel, newItem: MinePageModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MinePageModel, newItem: MinePageModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}