package cn.edu.bjtu.gs.main.personalinformation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.bjtu.gs.databinding.ActivityPersonalInformationBinding
import cn.edu.bjtu.gs.main.personalinformation.model.PlaceModel
import cn.edu.bjtu.gs.view.picker.DatePicker
import cn.edu.bjtu.gs.view.threeitempicker.IMultiItemPickerModel
import cn.edu.bjtu.gs.view.threeitempicker.MultiItemPickerDialog
import com.ripple.tool.extend.forEach
import java.util.*

class PersonalInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.phoneNumInput.setOnClickListener {
//            val now: Calendar = Calendar.getInstance()
//            now.set(Calendar.YEAR, 1985)
//
//            DatePicker(
//                this,
//                true,
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DATE)
//            ).setOnDateTimeSetListener {
//                val birthdayTime = it.time
////                tvDataPicker.setText(formatter.format(birthdayTime.getTime()))
//            }.show()
            val list = mutableListOf<PlaceModel>()
            10.forEach {
                list.add(PlaceModel("测试" + it))
            }

            val dialog = MultiItemPickerDialog()
            dialog.showPicker(this, list)
        }
    }

    private fun initData() {

    }
}