package cn.edu.bjtu.gs.main.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.databinding.ActivityNotifacationBinding
import cn.edu.bjtu.gs.main.notification.api.NotificationPostParam
import cn.edu.bjtu.gs.main.notification.api.NotificationResponse
import com.ripple.http.extend.httpPost
import com.ripple.log.tpyeextend.toLogD

@UserStatusSettingAnnotation(true)
class NotificationActivity : BaseActivity() {
    private lateinit var binding: ActivityNotifacationBinding
    private val viewModel by viewModels<NotificationViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotifacationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        Handler().postDelayed({
            initData()
        },200)
    }

    private fun initView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
        httpPost {
            params = NotificationPostParam()

            onStart {
                showLoadingDialog()
            }

            onSuccess<NotificationResponse> {
                it.toLogD()
            }

            onFinish {
                dismissLoadingDialog()
            }

        }
    }
}