package com.github.hugo.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.hugo.base.BaseFragment
import com.github.hugo.databinding.FragmentImageViewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author 努尔江
 * Created on: 2023/5/19
 * @project hugo
 * Description:
 **/

@AndroidEntryPoint
class FragmentImageView : BaseFragment<FragmentImageViewBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentImageViewBinding.inflate(inflater,container,false)

    override fun initViews() {

    }

}