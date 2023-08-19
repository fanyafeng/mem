package cn.edu.bjtu.gs.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import com.ripple.dialog.custom.LoadingSimpleDialog

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun logout() {
        (activity as BaseActivity).logout()
    }


    fun showLoadingDialog() {
        (activity as BaseActivity).showLoadingDialog()
    }

    fun dismissLoadingDialog() {
        (activity as BaseActivity).dismissLoadingDialog()
    }
}