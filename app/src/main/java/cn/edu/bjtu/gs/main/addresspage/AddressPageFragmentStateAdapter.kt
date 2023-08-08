package cn.edu.bjtu.gs.main.addresspage

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class AddressPageFragmentStateAdapter(private val fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    var fragmentList: List<Fragment> = mutableListOf()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }


}