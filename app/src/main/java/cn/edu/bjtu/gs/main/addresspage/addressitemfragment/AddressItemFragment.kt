package cn.edu.bjtu.gs.main.addresspage.addressitemfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentAddressItemBinding
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.adapter.AddressItemAdapter
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.api.FriendListPostParam
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.model.AddressItemModel
import com.ripple.http.extend.httpPost
import com.ripple.log.tpyeextend.toLogD
import net.sourceforge.pinyin4j.PinyinHelper

class AddressItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddressItemFragment()
    }

    private lateinit var viewModel: AddressItemViewModel
    private var binding: FragmentAddressItemBinding? = null
    private val adapter = AddressItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressItemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddressItemViewModel::class.java]
//        val text = PinyinHelper.toHanyuPinyinStringArray('中')
//        val sb = StringBuffer()
//        text.forEach {
//            sb.append(it)
//        }
//        binding?.addressItemEmptyTextView?.text = sb.toString()

        initView()
        initData()
    }

    private fun initView() {
        binding?.addressItemRecyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.addressItemRecyclerView?.adapter = adapter
    }

    private fun initData() {
        httpPost {
            params = FriendListPostParam()

            onSuccess<List<AddressItemModel>> {
                it.toString().toLogD()
//                adapter.submitList(it)

            }

            onFailed {
                it.message.toString().toLogD()
            }
        }
    }

}