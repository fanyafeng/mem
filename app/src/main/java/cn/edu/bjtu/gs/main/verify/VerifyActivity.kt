package cn.edu.bjtu.gs.main.verify

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivityVerifyBinding
import cn.edu.bjtu.gs.main.verify.api.VerifyPostParam
import cn.edu.bjtu.gs.main.verify.api.VerifyResponse
import com.ripple.dialog.extend.showToast
import com.ripple.http.extend.httpPost

class VerifyActivity : BaseActivity() {

    private lateinit var binding: ActivityVerifyBinding
    private val viewModel: VerifyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        binding.loginNumInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (!binding.loginNumInput.text.toString().trim()
                        .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                        .isNullOrEmpty()
                ) {
                    binding.login.setBackgroundColor(Color.parseColor("#0052d9"))
                } else {
                    binding.login.setBackgroundColor(Color.parseColor("#bbd3fb"))
                }
            }

        })

        binding.loginPasswordInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (!binding.loginNumInput.text.toString().trim()
                        .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                        .isNullOrEmpty()
                ) {
                    binding.login.setBackgroundColor(Color.parseColor("#0052d9"))
                } else {
                    binding.login.setBackgroundColor(Color.parseColor("#bbd3fb"))
                }
            }
        })
    }

    private fun initData() {
        if (!binding.loginNumInput.text.toString().trim()
                .isNullOrEmpty() && !binding.loginPasswordInput.text.toString().trim()
                .isNullOrEmpty()
        ) {
            binding.login.setOnClickListener {
                httpPost {
                    val fromParam = VerifyPostParam()
                    fromParam.number = binding.loginNumInput.text.toString().trim()
                    fromParam.idcard = binding.loginPasswordInput.text.toString().trim()
                    params = fromParam

                    onSuccess<VerifyResponse> {

                    }

                    onFailed {
                        showToast(it.message ?: "")
                    }

                }
            }
        }
    }
}