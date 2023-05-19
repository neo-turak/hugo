package com.github.hugo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun killMySelf() {
        activity?.finish()
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initViews()

}