package cn.edu.bjtu.gs.main.publishpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import cn.edu.bjtu.gs.databinding.FragmentPublishPageBinding
import cn.edu.bjtu.gs.main.publishactivity.PublishActivity
import cn.edu.bjtu.gs.main.publishrequirement.PublishRequirementActivity
import cn.edu.bjtu.gs.main.publishviewholders.PublishModel
import cn.edu.bjtu.gs.main.publishviewholders.PublishViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import java.util.concurrent.ConcurrentHashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PublishPageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var binding: FragmentPublishPageBinding? = null
    private lateinit var viewModel: PublishViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPublishPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[PublishViewModel::class.java]
        init()
        initView()
        initData()
    }

    private fun init() {

    }

    private fun initView() {
        binding?.leftButton?.setOnClickListener {
            startActivity(Intent(context, PublishActivity::class.java))
        }

        binding?.rightButton?.setOnClickListener {
            startActivity(Intent(context, PublishRequirementActivity::class.java))
        }
    }

    private fun initData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PublishPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val pool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<PublishViewModel, PublishModel>>()
    }
}