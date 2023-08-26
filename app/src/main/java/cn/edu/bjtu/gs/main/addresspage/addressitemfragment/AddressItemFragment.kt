package cn.edu.bjtu.gs.main.addresspage.addressitemfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.edu.bjtu.gs.R

class AddressItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddressItemFragment()
    }

    private lateinit var viewModel: AddressItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_address_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddressItemViewModel::class.java)
    }

}