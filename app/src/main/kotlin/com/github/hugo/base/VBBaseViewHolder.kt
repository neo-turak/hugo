package com.github.hugo.base

import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author 努尔江
 * Created on: 2023/5/12
 * @project hugo
 * Description:
 **/

class VBBaseViewHolder<VB:ViewBinding>(val binding:VB):BaseViewHolder(binding.root) {
}