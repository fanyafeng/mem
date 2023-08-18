package cn.edu.bjtu.gs.main.messagepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.FragmentMessagePageBinding
import cn.edu.bjtu.gs.main.BaseFragment
import cn.edu.bjtu.gs.main.messagepage.viewholders.AbsMessagePageBindingBaseViewHolder
import cn.edu.bjtu.gs.main.messagepage.viewholders.MessagePageEmptyViewHolder
import cn.edu.bjtu.gs.main.messagepage.viewholders.MessagePagePersonViewHolder
import cn.edu.bjtu.gs.main.messagepage.viewholders.MessagePageTopViewHolder
import cn.edu.bjtu.gs.main.minepage.MinePageModel
import cn.edu.bjtu.gs.main.minepage.MinePageViewModel
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MessagePageFragment : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: MessagePageViewModel
    private var binding: FragmentMessagePageBinding? = null
    private val adapter = MessagePageAdapter()

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
        binding = FragmentMessagePageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MessagePageViewModel::class.java]

        init()
        initView()
        initData()
    }

    private fun init() {
        adapter.viewModel = viewModel
        StrategyWithPriorityIntBindingLinkedMap<MessagePageViewModel, MessagePageModel>().apply {
            register(MessagePageEmptyViewHolder.Factory::class.java)
            register(MessagePagePersonViewHolder.Factory::class.java)
            register(MessagePageTopViewHolder.Factory::class.java)
        }
    }

    private fun initView() {
        binding?.rvMessagePage?.layoutManager = LinearLayoutManager(activity)
        val list = mutableListOf<MessagePageModel>().apply {
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.TOP_HEADER))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
            add(MessagePageModel(AbsMessagePageBindingBaseViewHolder.PERSON))
        }
        adapter.submitList(list)
        binding?.rvMessagePage?.adapter = adapter
    }

    private fun initData() {
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessagePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val factoryBindingMapPool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<MessagePageViewModel, MessagePageModel>>()
    }
}