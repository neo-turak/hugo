package com.github.hugo.adapter

import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBViewHolder
import com.github.hugo.databinding.ItemWaitingOrderChildBinding
import com.github.hugo.model.WaitingOrderBean

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/16 下午1:16
 *@project  hugo
 *Think Twice, Code Once!
 */
class WaitingOrderChildAdapter :
    BaseBindingAdapter<ItemWaitingOrderChildBinding, WaitingOrderBean.WaitingOrderBeanItem.OrderDetailsEntity>() {
    override fun convert(
        holder: VBViewHolder<ItemWaitingOrderChildBinding>,
        item: WaitingOrderBean.WaitingOrderBeanItem.OrderDetailsEntity
    ) {
        holder.vb.ivId.text = "${item.orderItemId}"
        holder.vb.tvName.text = "${item.foodId}"
        holder.vb.tvAmount.text = "${item.price}"
    }
}