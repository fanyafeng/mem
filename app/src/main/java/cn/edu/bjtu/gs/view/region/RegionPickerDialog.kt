package cn.edu.bjtu.gs.view.region

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.DialogRegionPickerLayoutBinding
import cn.edu.bjtu.gs.databinding.DialogThreeItemPickerLayoutBinding
import com.ripple.dialog.extend.showToast
import com.ripple.dialog.widget.impl.RippleDialog
import com.ripple.http.extend.httpGet
import com.ripple.http.extend.httpPost
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


class RegionPickerDialog {

    private var dialog: RippleDialog? = null
    private var dialogView: View? = null
    private var dialogBinding: DialogRegionPickerLayoutBinding? = null

    fun showPicker(context: Context) {
        if (dialogView == null) {
            dialogView =
                LayoutInflater.from(context).inflate(R.layout.dialog_region_picker_layout, null)
        }
        if (dialog == null) {
            dialog = RippleDialog(context, dialogView!!).apply {
                setGravity(Gravity.BOTTOM)
                setCancel(true)
            }

        }

        if (dialogBinding == null) {
            dialogBinding = DialogRegionPickerLayoutBinding.bind(dialogView!!)
        }
        httpGet {
            params = RegionPostParam()

            onSuccess<RegionSonModel> { list ->
                with(dialogBinding!!) {
                    secondWheel.visibility = View.VISIBLE
                    secondWheel.visibleItems = 5
                    list.region.toLogD()

                    val adapter = RegionPickerAdapter()
                    adapter.list = list.region

                    val secondAdapter = RegionPickerAdapter()


                    firstWheel.run {
                        visibleItems = 5
                        firstWheel.adapter = adapter
                        addChangingListener { wheel, oldValue, newValue ->
                            newValue.toLogD("第一个 ")

                            val secondList = list.region!!.get(newValue).children
                            secondAdapter.list = secondList
                            secondWheel.adapter = secondAdapter
                            secondWheel.addChangingListener { secondWheel, oldSecondValue, newSecondValue ->
                                newSecondValue.toLogD("第二个 ")
                            }

                        }
                    }
                }
                dialog?.show()
            }

            onFailed {
                context.showToast(it.message ?: "")
            }
        }


    }

}