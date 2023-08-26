package cn.edu.bjtu.gs.main.addresspage.addressitemfragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.edu.bjtu.gs.databinding.ItemAddressPersionHeaderLayoutBinding
import cn.edu.bjtu.gs.databinding.ItemAddressPersionLayoutBinding
import cn.edu.bjtu.gs.databinding.ItemNotificationMessageLayoutBinding
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.model.AddressItemModel
import cn.edu.bjtu.gs.main.notification.NotificationModel
import cn.edu.bjtu.gs.view.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter
import com.ripple.sdk.binding.BindingViewHolder
import com.ripple.sdk.binding.newBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/26 16:32
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class AddressItemAdapter :
    ListAdapter<AddressItemModel, BindingViewHolder<ItemAddressPersionLayoutBinding>>(COMPARATOR),
    StickyRecyclerHeadersAdapter<BindingViewHolder<ItemAddressPersionHeaderLayoutBinding>> {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemAddressPersionLayoutBinding> {
        return newBindingViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<ItemAddressPersionLayoutBinding>,
        position: Int
    ) {
    }

    override fun getHeaderId(position: Int): Long {
        val model = getItem(position)
        return model.headerId ?: 0L
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): BindingViewHolder<ItemAddressPersionHeaderLayoutBinding> {
        return newBindingViewHolder(parent)
    }

    override fun onBindHeaderViewHolder(
        holder: BindingViewHolder<ItemAddressPersionHeaderLayoutBinding>?,
        position: Int
    ) {
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<AddressItemModel>() {
            override fun areItemsTheSame(
                oldItem: AddressItemModel, newItem: AddressItemModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: AddressItemModel, newItem: AddressItemModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}