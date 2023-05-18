package com.github.hugo.adapter

import androidx.fragment.app.FragmentActivity
import coil.load
import com.github.hugo.R
import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBBaseViewHolder
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
constructor(
    activity: FragmentActivity
) : BaseBindingAdapter<ItemImageBinding, ImageModel>() {
    override fun convert(holder: VBBaseViewHolder<ItemImageBinding>, item: ImageModel) {
        holder.binding.image.load(item.urls.regular) {
            crossfade(true)
            placeholder(R.drawable.spinner_1s_200px)
        }
    }
}