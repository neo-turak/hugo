package com.github.hugo.ui.adapter

import android.content.Context
import com.github.hugo.base.BaseBindingBindingAdapter
import com.github.hugo.base.VBBaseViewHolder
import com.github.hugo.databinding.ItemSoftwareBinding
import com.github.hugo.room.SoftwareEntity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/


class MainAdapter
@Inject
constructor(
   @ActivityContext
   context: Context
) : BaseBindingBindingAdapter<ItemSoftwareBinding, SoftwareEntity>() {
    override fun convert(
        holder: VBBaseViewHolder<ItemSoftwareBinding>,
        item: SoftwareEntity
    ) {
        holder.binding.tvContent.text = item.title
    }

}