package com.github.hugo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.hugo.databinding.FragmentMineBinding

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/6 上午12:26
 *@project  hugo
 *Think Twice, Code Once!
 */
class MineFragment : Fragment() {
    private var _binding: FragmentMineBinding? = null
    private val binding by lazy { _binding!! }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding.root
    }
}