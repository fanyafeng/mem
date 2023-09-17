package cn.edu.bjtu.gs.main.dialog.industrydialog

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.DialogOneItemPickerLayoutBinding
import com.ripple.dialog.widget.impl.RippleDialog
import com.ripple.http.extend.httpGet
import com.ripple.log.tpyeextend.toLogD
import com.ripple.tool.kttypelians.SuccessLambda

/**
 * Author: fanyafeng
 * Date: 2023/9/10 14:46
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class IndustryDialog {

    private var dialog: RippleDialog? = null
    private var dialogView: View? = null
    private var dialogBinding: DialogOneItemPickerLayoutBinding? = null

    fun showIndustryDialog(
        context: Context,
        url: String? = null,
        title: String? = null,
        lambda: SuccessLambda<IndustryModel> = null
    ) {
        if (dialogView == null) {
            dialogView =
                LayoutInflater.from(context).inflate(R.layout.dialog_one_item_picker_layout, null)
        }
        if (dialog == null) {
            dialog = RippleDialog(context, dialogView!!).apply {
                setGravity(Gravity.BOTTOM)
                setCancel(true)
            }

        }

        if (dialogBinding == null) {
            dialogBinding = DialogOneItemPickerLayoutBinding.bind(dialogView!!)
            dialogBinding?.firstWheel?.visibleItems = 5
            title?.let {
                dialogBinding?.title?.text = it
            }


            dialogBinding?.cancel?.setOnClickListener {
                dialog?.dismiss()
            }
        }

        if (url == null) {
            return
        }

        httpGet {
            params = IndustryGetParams(url ?: "")

            onSuccess<List<IndustryModel>> {
                val adapter = IndustryPickerAdapter()
                adapter.list = it
                dialogBinding?.firstWheel?.adapter = adapter

                dialogBinding?.confirm?.setOnClickListener { _ ->
                    val position = dialogBinding?.firstWheel?.currentItem ?: 0
                    val result = it[position]
                    lambda?.invoke(result)
                    dialog?.dismiss()
                }

                dialog?.show()
            }

            onFailed {
                it.message.toLogD()
            }
        }
    }

    fun dismissIndustryDialog() {
        dialog?.dismiss()
    }
}