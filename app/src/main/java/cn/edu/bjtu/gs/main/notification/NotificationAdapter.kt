package cn.edu.bjtu.gs.main.notification

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.databinding.ItemNotificationMessageLayoutBinding
import cn.edu.bjtu.gs.main.messagepage.MessagePageModel
import com.ripple.sdk.binding.BindingViewHolder
import com.ripple.sdk.binding.newBindingViewHolder

/**
 * Author: fanyafeng
 * Date: 2023/8/19 09:54
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class NotificationAdapter :
    ListAdapter<NotificationModel, BindingViewHolder<ItemNotificationMessageLayoutBinding>>(
        COMPARATOR
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemNotificationMessageLayoutBinding> {
        return newBindingViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<ItemNotificationMessageLayoutBinding>,
        position: Int
    ) {
        val model = getItem(position)
        with(holder.binding) {
            tvTime.text = model.creatTime
            tvContent.text = model.infoBody
            ivIcon.setOnClickListener {

            }
        }

    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<NotificationModel>() {
            override fun areItemsTheSame(
                oldItem: NotificationModel, newItem: NotificationModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: NotificationModel, newItem: NotificationModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}