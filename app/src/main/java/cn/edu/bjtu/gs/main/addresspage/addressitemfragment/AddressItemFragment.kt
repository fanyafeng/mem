package cn.edu.bjtu.gs.main.addresspage.addressitemfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentAddressItemBinding
import net.sourceforge.pinyin4j.PinyinHelper

class AddressItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddressItemFragment()
    }

    private lateinit var viewModel: AddressItemViewModel
    private lateinit var binding: FragmentAddressItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddressItemViewModel::class.java]
        val text = PinyinHelper.toHanyuPinyinStringArray('中')
        val sb = StringBuffer()
        text.forEach {
            sb.append(it)
        }
        binding.addressItemEmptyTextView.text = sb.toString()


    }

}