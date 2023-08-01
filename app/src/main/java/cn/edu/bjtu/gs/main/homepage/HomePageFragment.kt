package cn.edu.bjtu.gs.main.homepage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentHomePageBinding
import cn.edu.bjtu.gs.main.login.LoginActivity
import cn.edu.bjtu.gs.main.register.RegisterActivity
import cn.edu.bjtu.gs.main.splash.SplashActivity
import cn.edu.bjtu.gs.main.verify.VerifyActivity

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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentHomePageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun initView() {
        binding?.test?.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        binding?.register?.setOnClickListener {
            startActivity(Intent(activity, RegisterActivity::class.java))
        }

        binding?.splash?.setOnClickListener {
            startActivity(Intent(activity, SplashActivity::class.java))
        }

        binding?.verify?.setOnClickListener {
            startActivity(Intent(activity, VerifyActivity::class.java))
        }


    }

    private fun initData() {

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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}