package com.github.hugo.adapter

import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBViewHolder
import com.github.hugo.databinding.ItemSoftwareBinding
import com.github.hugo.room.SoftwareEntity
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/


class MainAdapter
@Inject
constructor() : BaseBindingAdapter<ItemSoftwareBinding, SoftwareEntity>() {
    override fun convert(
        holder: VBViewHolder<ItemSoftwareBinding>,
        item: SoftwareEntity
    ) {
        holder.vb.software = item
    }

}