package com.github.hugo.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.hugo.base.BaseDialog
import com.github.hugo.databinding.DialogAboutBinding

/**
 * @author 努尔江
 * Created on: 2023/5/10
 * @project hugo
 * Description:
 **/

class ConfirmDialog : BaseDialog<DialogAboutBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogAboutBinding {
        return DialogAboutBinding.inflate(layoutInflater,container,false)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.tvHola.text = "哈哈哈哈哈"
    }
}