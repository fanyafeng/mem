package cn.edu.bjtu.gs.main.publishviewholders

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ItemImageLayoutBinding
import cn.edu.bjtu.gs.databinding.ItemPublishImageLayoutBinding
import com.bumptech.glide.Glide
import com.ripple.media.picker.image.extend.imagePick
import com.ripple.media.picker.model.RippleMediaModel
import com.ripple.sdk.binding.BindingViewHolder
import com.ripple.sdk.binding.newBindingViewHolder
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/26 14:21
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishImageViewHolder(val binding: ItemPublishImageLayoutBinding) :
    AbsPublishBindingBaseViewHolder(binding) {

    private val imageList = mutableListOf<RippleMediaModel>()
    val adapter = PublishImageAdapter()

    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.title?.let {
            binding.tvTitle.text = it
        }

        val manager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.rvImage.layoutManager = manager
        binding.rvImage.adapter = adapter
        adapter.submitList(imageList)
    }

    inner class PublishImageAdapter :
        ListAdapter<RippleMediaModel, BindingViewHolder<ItemImageLayoutBinding>>(
            COMPARATOR
        ) {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BindingViewHolder<ItemImageLayoutBinding> {
            return newBindingViewHolder(
                parent,
            )
        }

        override fun onBindViewHolder(
            holder: BindingViewHolder<ItemImageLayoutBinding>,
            position: Int
        ) {
            val listSize = currentList.size
            if (listSize < 6) {
                if (position == listSize) {
                    holder.binding.deleteImageView.visibility = View.GONE
                    Glide.with(holder.binding.imageView).load(R.drawable.nav_btn_camera_white)
                        .into(holder.binding.imageView)
                    holder.binding.imageView.setOnClickListener {
                        holder.binding.root.context.imagePick(6 - listSize) {
                            imageList.addAll(it)
                            adapter.submitList(imageList)
                            adapter.notifyDataSetChanged()
                        }

                    }
                } else {
                    holder.binding.deleteImageView.visibility = View.VISIBLE
                    val model = getItem(position)
                    Glide.with(holder.binding.imageView).load(model.getPath())
                        .into(holder.binding.imageView)
                    holder.binding.deleteImageView.setOnClickListener {
                        imageList.removeAt(position)
                        adapter.submitList(imageList)
                        adapter.notifyDataSetChanged()
                    }
                }
            } else {
                holder.binding.deleteImageView.visibility = View.VISIBLE
                val model = getItem(position)
                Glide.with(holder.binding.imageView).load(model.getPath())
                    .into(holder.binding.imageView)
                holder.binding.deleteImageView.setOnClickListener {
                    imageList.removeAt(position)
                    adapter.submitList(imageList)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        override fun getItemCount(): Int {
            val listSize = currentList.size
            return if (listSize < 6) {
                listSize + 1
            } else {
                super.getItemCount()
            }
        }


    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<RippleMediaModel>() {
            override fun areItemsTheSame(
                oldItem: RippleMediaModel,
                newItem: RippleMediaModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RippleMediaModel,
                newItem: RippleMediaModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    @ViewHolderIntAnnotation(PUBLISH_IMAGE)
    class Factory :
        AbsPublishBindingViewHolderAutoFactory<PublishImageViewHolder, ItemPublishImageLayoutBinding>()
}

