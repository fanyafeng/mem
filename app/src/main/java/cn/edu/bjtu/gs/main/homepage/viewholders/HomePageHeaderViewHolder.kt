package cn.edu.bjtu.gs.main.homepage.viewholders

import android.content.Intent
import cn.edu.bjtu.gs.databinding.ItemHomePageHeaderLayoutBinding
import cn.edu.bjtu.gs.main.h5.H5Activity
import cn.edu.bjtu.gs.main.homepage.HomePageModel
import cn.edu.bjtu.gs.main.homepage.HomePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:47
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageHeaderViewHolder(val binding: ItemHomePageHeaderLayoutBinding) :
    AbsHomePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: HomePageViewModel?,
        dataSource: HomePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
        binding.root.setOnClickListener {
            binding.root.context.startActivity(
                Intent(
                    binding.root.context,
                    H5Activity::class.java
                ).apply {
                    putExtra(H5Activity.H5_URL, "http://45.76.101.144:8501/")
                }
            )
        }
    }

    @ViewHolderIntAnnotation(TOP_HEADER)
    class Factory() :
        AbsHomePageBindingViewHolderAutoFactory<HomePageHeaderViewHolder, ItemHomePageHeaderLayoutBinding>()
}