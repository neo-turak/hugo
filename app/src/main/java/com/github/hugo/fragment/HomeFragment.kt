package com.github.hugo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.github.hugo.adapter.WaitingOrderAdapter
import com.github.hugo.databinding.FragmentHomeBinding
import com.github.hugo.vm.MainViewModel

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/6 上午12:25
 *@project  hugo
 *Think Twice, Code Once!
 */
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding by lazy { _binding!! }
    private val vm: MainViewModel by activityViewModels()
    private val adapter = WaitingOrderAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.shopInfoModel.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
            binding.ivBg.load(it.bgImage)
        }
        binding.rvOrder.adapter = adapter
        vm.waitingOrderModel.observe(viewLifecycleOwner) {
           // adapter.setNewInstance(it)
        }
        vm.getWaitingOrderDetails()
    }

}