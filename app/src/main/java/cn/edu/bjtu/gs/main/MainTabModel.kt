package cn.edu.bjtu.gs.main

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ripple.log.tpyeextend.toLogD


/**
 * Author: fanyafeng
 * Data: 2023/7/25 09:31
 * Email: fanyafeng@live.cn
 * Description:
 *                                   _ooOoo_
 *                                  o8888888o
 *                                  88" . "88
 *                                  (| -_- |)
 *                                   O\ = /O
 *                               ____/`---'\____
 *                             .   ' \\| |// `.
 *                              / \\||| : |||// \
 *                            / _||||| -:- |||||- \
 *                              | | \\\ - /// | |
 *                            | \_| ''\---/'' | |
 *                             \ .-\__ `-` ___/-. /
 *                          ___`. .' /--.--\ `. . __
 *                       ."" '< `.___\_<|>_/___.' >'"".
 *                      | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *                        \ \ `-. \_ __\ /__ _/ .-` / /
 *                ======`-.____`-.___\_____/___.-`____.-'======
 *                                   `=---='
 *                .............................................
 *                         佛祖保佑             永无BUG
 *                 佛曰:
 *                         写字楼里写字间，写字间里程序员；
 *                         程序人员写程序，又拿程序换酒钱。
 *                         酒醒只在网上坐，酒醉还来网下眠；
 *                         酒醉酒醒日复日，网上网下年复年。
 *                         但愿老死电脑间，不愿鞠躬老板前；
 *                         奔驰宝马贵者趣，公交自行程序员。
 *                         别人笑我忒疯癫，我笑自己命太贱；
 *                         不见满街漂亮妹，哪个归得程序员？
 *///Github See: https://github.com/fanyafeng


data class MainTabModel(
    var position: Int,
    var icon: ImageView,
    var title: TextView,
    var selectId: Int,
    var unSelectId: Int,
    val group: View
) {

    var mainTabModelList: MutableList<MainTabModel>? = null
    var mainFragmentList: MutableList<Fragment>? = null
    var fragmentManager: FragmentManager? = null

    init {
        group.setOnClickListener { _ ->
            mainTabModelList?.forEachIndexed { index, mainTabModel ->
                if (index == position) {
                    mainTabModel.setChecked()
                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    mainFragmentList?.get(position)?.let { fragment ->
                        fragmentTransaction?.show(fragment)
                        fragmentTransaction?.commit()
                    }

                } else {
                    mainTabModel.setUnChecked()
                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    mainFragmentList?.get(index)?.let { fragment ->
                        fragmentTransaction?.hide(fragment)
                        fragmentTransaction?.commit()
                    }
                }
            }
        }
    }


    fun setChecked() {
        title.setTextColor(Color.BLUE)
        icon.setImageResource(selectId)
    }

    fun setUnChecked() {
        title.setTextColor(Color.BLACK)
        icon.setImageResource(unSelectId)
    }
}