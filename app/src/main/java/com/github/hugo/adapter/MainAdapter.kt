package com.github.hugo.adapter

import com.github.hugo.databinding.ItemSoftwareBinding
import com.github.hugo.model.SoftwareModel
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/


class MainAdapter
@Inject
constructor() : BaseBindingAdapter<ItemSoftwareBinding, SoftwareModel.SoftwareEntity>() {
    override fun convert(
        holder: VBViewHolder<ItemSoftwareBinding>,
        item: SoftwareModel.SoftwareEntity
    ) {
        holder.vb.software = item
    }

}