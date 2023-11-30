package com.github.hugo.adapter

import coil.load
import com.github.hugo.R
import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBViewHolder
import com.github.hugo.databinding.ItemImageBinding
import com.github.hugo.model.ImageModel
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/5/6
 * @project hugo
 * Description:
 **/

class ImageAdapter
@Inject
constructor() : BaseBindingAdapter<ItemImageBinding, ImageModel>() {
    override fun convert(holder: VBViewHolder<ItemImageBinding>, item: ImageModel) {
        holder.vb.image.load(item.urls.regular){
            crossfade(true)
            placeholder(R.drawable.spinner_1s_200px)
        }
    }
}