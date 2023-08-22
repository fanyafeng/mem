package cn.edu.bjtu.gs.main.minepage.viewholders

import android.content.Intent
import cn.edu.bjtu.gs.databinding.MinePageTopHeaderLayoutBinding
import cn.edu.bjtu.gs.main.login.LoginActivity
import cn.edu.bjtu.gs.main.login.manager.UserInfoManager
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.dialog.widget.impl.RippleDialog
import com.ripple.sdk.ui.recyclerview.multitypviewholder.annotation.ViewHolderIntAnnotation

/**
 * Author: fanyafeng
 * Date: 2023/8/11 11:08
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MinePageTopHeaderViewHolder(val binding: MinePageTopHeaderLayoutBinding) :
    AbsMinePageBindingBaseViewHolder(binding) {

    override fun bindData(
        viewModel: MinePageViewModel?,
        dataSource: MinePageModel?,
        position: Int
    ) {
        super.bindData(viewModel, dataSource, position)
        if (viewModel?.isLogin == true) {
            val userInfo = UserInfoManager.getInstance().userInfo
            binding.tvName.text = userInfo?.nickName ?: ""
            binding.tvNumber.text = userInfo?.number ?: ""
        } else {
            binding.root.setOnClickListener {
                mContext?.startActivity(Intent(mContext, LoginActivity::class.java))
            }
        }

    }

    @ViewHolderIntAnnotation(TOP_HEADER)
    class Factory :
        AbsMinePageBindingViewHolderAutoFactory<MinePageTopHeaderViewHolder, MinePageTopHeaderLayoutBinding>()
}