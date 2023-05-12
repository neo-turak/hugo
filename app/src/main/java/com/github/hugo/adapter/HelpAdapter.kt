package com.github.hugo.adapter

import androidx.viewbinding.ViewBinding
import coil.load
import com.github.hugo.R
import com.github.hugo.base.BaseMultiItemAdapter
import com.github.hugo.base.VBBaseViewHolder
import com.github.hugo.databinding.ItemImageBinding
import com.github.hugo.databinding.ItemSoftwareBinding
import com.github.hugo.model.AppInfoModel
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/5/11
 * @project hugo
 * Description:
 **/

class HelpAdapter
    @Inject
    constructor() : BaseMultiItemAdapter<AppInfoModel>() {
    init {
        addViewBinding(0, ItemSoftwareBinding::inflate)
        addViewBinding(1, ItemImageBinding::inflate)
    }

    override fun convert(holder: VBBaseViewHolder<ViewBinding>, item: AppInfoModel) {
        when(val binding =holder.binding){
            is ItemImageBinding ->{
                binding.image.load(item.content){
                    placeholder(R.drawable.spinner_1s_200px)
                }
            }
            is ItemSoftwareBinding ->{
                binding.tvContent.text = item.content
            }
        }
    }


}