package com.github.hugo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.hugo.databinding.FragmentVipBinding

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/6 上午12:25
 *@project  hugo
 *Think Twice, Code Once!
 */
class VIPFragment : Fragment() {
    private var _binding: FragmentVipBinding? = null
    private val binding by lazy { _binding!! }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVipBinding.inflate(inflater, container, false)
        return binding.root
    }
}