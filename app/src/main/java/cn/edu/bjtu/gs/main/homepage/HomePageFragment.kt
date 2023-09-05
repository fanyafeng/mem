package cn.edu.bjtu.gs.main.homepage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentHomePageBinding
import cn.edu.bjtu.gs.main.forgotpassword.ForgotPasswordActivity
import cn.edu.bjtu.gs.main.homepage.api.HomePagePostParam
import cn.edu.bjtu.gs.main.homepage.api.HomePageResponse
import cn.edu.bjtu.gs.main.homepage.viewholders.HomePageActivityViewHolder
import cn.edu.bjtu.gs.main.login.LoginActivity
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import cn.edu.bjtu.gs.main.personalinformation.PersonalInformationActivity
import cn.edu.bjtu.gs.main.register.RegisterActivity
import cn.edu.bjtu.gs.main.setpassword.SetPasswordActivity
import cn.edu.bjtu.gs.main.splash.SplashActivity
import cn.edu.bjtu.gs.main.verify.VerifyActivity
import com.ripple.http.extend.httpPost
import com.ripple.log.tpyeextend.toLogD
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentHomePageBinding? = null
    private val adapter = HomePageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun initView() {
        StrategyWithPriorityIntBindingLinkedMap<HomePageViewModel, HomePageModel>().apply {
            register(HomePageActivityViewHolder.Factory::class.java)
        }
        binding?.homePageRecyclerView?.layoutManager = LinearLayoutManager(context)
    }

    private fun initData() {
        httpPost {
            val fromParam = HomePagePostParam()
            params = fromParam

            onSuccess<HomePageResponse> {
//                it.rows.toString().toLogD()
                binding?.homePageRecyclerView?.adapter = adapter
                adapter.submitList(it.rows)
            }

            onFailed {
//                it.message.toLogD()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val factoryBindingMapPool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<HomePageViewModel, HomePageModel>>()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}