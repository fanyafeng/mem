package cn.edu.bjtu.gs.main.minepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.edu.bjtu.gs.databinding.FragmentMinePageBinding
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageEmptyViewHolder
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageTitleViewHolder
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageTitleWithArrowViewHolder
import cn.edu.bjtu.gs.main.minepage.viewholders.MinePageTopHeaderViewHolder
import com.ripple.sdk.ui.recyclerview.multitypviewholder.factory.StrategyBaseIntBindingFactory
import com.ripple.sdk.ui.recyclerview.multitypviewholder.linkmap.StrategyWithPriorityIntBindingLinkedMap
import java.util.concurrent.ConcurrentHashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MinePageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: MinePageViewModel
    private var binding: FragmentMinePageBinding? = null

    private val adapter = MinePageAdapter()

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
        binding = FragmentMinePageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MinePageViewModel::class.java]

        init()
        initView()
        initData()
    }

    private fun init() {
        adapter.viewModel = viewModel
        StrategyWithPriorityIntBindingLinkedMap<MinePageViewModel, MinePageModel>().apply {
            register(MinePageEmptyViewHolder.Factory::class.java)
            register(MinePageTopHeaderViewHolder.Factory::class.java)
            register(MinePageTitleViewHolder.Factory::class.java)
            register(MinePageTitleWithArrowViewHolder.Factory::class.java)
        }
    }

    private fun initView() {
        binding?.rvMinePage?.layoutManager = LinearLayoutManager(context)
        binding?.rvMinePage?.adapter = adapter

        val list = mutableListOf<MinePageModel>().apply {
            add(MinePageModel(0))
            add(MinePageModel(1))
            add(MinePageModel(2))
            add(MinePageModel(2))
            add(MinePageModel(2))
            add(MinePageModel(2))
        }
        adapter.submitList(list)
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
            MinePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val factoryBindingMapPool =
            ConcurrentHashMap<Int, StrategyBaseIntBindingFactory<MinePageViewModel, MinePageModel>>()

    }
}