package com.github.hugo.adapter

import androidx.core.content.ContextCompat
import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBViewHolder
import com.github.hugo.databinding.ItemHomeMenuBinding
import com.github.hugo.model.HomeMenuModel

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/7 下午1:09
 *@project  hugo
 *Think Twice, Code Once!
 */
class HomeMenuAdapter : BaseBindingAdapter<ItemHomeMenuBinding, HomeMenuModel>() {
    override fun convert(holder: VBViewHolder<ItemHomeMenuBinding>, item: HomeMenuModel) {
        holder.vb.ivImage.setImageDrawable(
            ContextCompat.getDrawable(
                holder.vb.ivImage.context,
                item.icon
            )
        )
        holder.vb.idName.text = item.name
    }
}