package cn.edu.bjtu.gs.main.addresspage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentAddressPageBinding
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.AddressItemFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddressPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressPageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentAddressPageBinding? = null

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
        binding = FragmentAddressPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragmentList = mutableListOf<Fragment>(
            AddressItemFragment.newInstance(),
            AddressItemFragment.newInstance(),
            AddressItemFragment.newInstance()
        )
        val adapter = AddressPageFragmentStateAdapter(this)
        adapter.fragmentList = fragmentList
        binding?.addressViewPager?.adapter = adapter

        TabLayoutMediator(
            binding?.addressTableLayout!!,
            binding?.addressViewPager!!
        ) { tab, position ->
            tab.text = "推荐"
        }.attach()

        binding?.addressTableLayout?.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding?.addressViewPager?.setCurrentItem(tab?.position ?: 0, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddressPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}