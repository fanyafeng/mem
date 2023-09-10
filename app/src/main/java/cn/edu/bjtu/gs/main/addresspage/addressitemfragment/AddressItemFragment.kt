package cn.edu.bjtu.gs.main.addresspage.addressitemfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.databinding.FragmentAddressItemBinding
import cn.edu.bjtu.gs.event.LogoutEvent
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.adapter.AddressItemAdapter
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.api.FriendListPostParam
import cn.edu.bjtu.gs.main.addresspage.addressitemfragment.model.AddressItemModel
import com.ripple.http.extend.httpPost
import com.ripple.log.tpyeextend.toLogD
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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
        EventBus.getDefault().register(this)
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

            onSuccess<List<AddressItemModel>> { resultList ->
                resultList.toString().toLogD()
                resultList.sortedBy { it.getNameHeaderId() }
                adapter.submitList(resultList)

            }

            onFailed {
                it.message.toString().toLogD()
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LogoutEvent) {
        initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        EventBus.getDefault().unregister(this)
    }

}