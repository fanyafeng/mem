package cn.edu.bjtu.gs.main.publishviewholders

import cn.edu.bjtu.gs.databinding.ItemPublishChooseTimeLayoutBinding
import cn.edu.bjtu.gs.main.dialog.datadialog.DateChoosePicker
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation
import java.util.Calendar

/**
 * Author: fanyafeng
 * Date: 2023/9/10 16:59
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishChooseTimeViewHolder(val binding: ItemPublishChooseTimeLayoutBinding) :
    AbsPublishBindingBaseViewHolder(binding) {
    override fun bindData(viewModel: PublishViewModel?, dataSource: PublishModel?, position: Int) {
        super.bindData(viewModel, dataSource, position)
        dataSource?.title?.let {
            binding.tvTitle.text = it
        }
        dataSource?.hintTitle?.let {
            binding.etContent.text = it
        }

        binding.root.setOnClickListener {
            val now: Calendar = Calendar.getInstance()
//            now.set(Calendar.YEAR, 1985)

            DateChoosePicker(
                binding.root.context,
                true,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DATE)
            ).setOnDateTimeSetListener {
                val birthdayTime = it.time
                dataSource?.result = birthdayTime.timeInMillis.toString()
            }.show()
        }

    }

    @ViewHolderIntAnnotation(PUBLISH_TIME)
    class Factory :
        AbsPublishBindingViewHolderAutoFactory<PublishChooseTimeViewHolder, ItemPublishChooseTimeLayoutBinding>()
}