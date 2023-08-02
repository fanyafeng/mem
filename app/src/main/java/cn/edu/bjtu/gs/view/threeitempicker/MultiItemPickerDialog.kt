package cn.edu.bjtu.gs.view.threeitempicker

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.DialogThreeItemPickerLayoutBinding
import com.ripple.dialog.widget.impl.RippleDialog
import com.ripple.log.tpyeextend.toLogD


/**
 * Author: fanyafeng
 * Data: 2023/8/1 16:49
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


class MultiItemPickerDialog {

    private var dialog: RippleDialog? = null
    private var dialogView: View? = null
    private var dialogBinding: DialogThreeItemPickerLayoutBinding? = null

    fun showPicker(context: Context, list: List<IMultiItemPickerModel>) {


        if (dialogView == null) {
            dialogView =
                LayoutInflater.from(context).inflate(R.layout.dialog_three_item_picker_layout, null)
        }
        if (dialog == null) {
            dialog = RippleDialog(context, dialogView!!).apply {
                setGravity(Gravity.BOTTOM)
                setCancel(true)
            }

        }

        if (dialogBinding == null) {
            dialogBinding = DialogThreeItemPickerLayoutBinding.bind(dialogView!!)
        }

        with(dialogBinding!!) {
            secondWheel.visibility = View.GONE
            thirdWheel.visibility = View.GONE

            val adapter = MultiItemPickerAdapter()
            adapter.list = list


            firstWheel.run {
                visibleItems = 5
                firstWheel.adapter = adapter
                addChangingListener { wheel, oldValue, newValue ->
                    newValue.toLogD("第一个 ")
                }
            }

//            secondWheel.run {
//                secondWheel.visibleItems = 5
//                secondWheel.adapter = adapter
//                addChangingListener { wheel, oldValue, newValue ->
//                    newValue.toLogD("第二个 ")
//                }
//            }
//
//            thirdWheel.run {
//                thirdWheel.visibleItems = 5
//                thirdWheel.adapter = adapter
//                addChangingListener { wheel, oldValue, newValue ->
//                    newValue.toLogD("第三个")
//                }
//            }
        }
        dialog?.show()
    }

}