package cn.edu.bjtu.gs.main.homepage

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.main.homepage.viewholders.AbsHomePageBindingBaseViewHolder
import cn.edu.bjtu.gs.main.homepage.viewholders.HomePageEmptyViewHolder
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.viewholder.StrategyBaseBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/17 16:02
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageAdapter :
    ListAdapter<HomePageModel, StrategyBaseBindingViewHolder<HomePageViewModel, HomePageModel>>(
        COMPARATOR
    ) {

    var viewModel: HomePageViewModel? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StrategyBaseBindingViewHolder<HomePageViewModel, HomePageModel> {
        return HomePageFragment.factoryBindingMapPool[viewType]?.onCreateViewHolder(
            parent,
            viewType
        )
            ?: HomePageEmptyViewHolder.getSample(parent, viewType)
    }

    override fun onBindViewHolder(
        holder: StrategyBaseBindingViewHolder<HomePageViewModel, HomePageModel>,
        position: Int
    ) {
        val model = getItem(position)
        holder.bindData(viewModel, model, position)
    }

    override fun getItemViewType(position: Int): Int {
        return AbsHomePageBindingBaseViewHolder.TOP_ACTIVITY
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<HomePageModel>() {
            override fun areItemsTheSame(
                oldItem: HomePageModel, newItem: HomePageModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: HomePageModel, newItem: HomePageModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}