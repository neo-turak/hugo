package com.github.hugo.adapter

import com.github.hugo.base.BaseBindingAdapter
import com.github.hugo.base.VBViewHolder
import com.github.hugo.databinding.ItemWaitingOrderBinding
import com.github.hugo.model.WaitingOrderBean
import com.github.neoturak.common.singleClick

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/16 下午12:47
 *@project  hugo
 *Think Twice, Code Once!
 */
class WaitingOrderAdapter :
    BaseBindingAdapter<ItemWaitingOrderBinding, WaitingOrderBean.WaitingOrderBeanItem.OrderEntity>() {
    override fun convert(
        holder: VBViewHolder<ItemWaitingOrderBinding>,
        item: WaitingOrderBean.WaitingOrderBeanItem.OrderEntity
    ) {
        val adapter = WaitingOrderChildAdapter()
        holder.vb.rvChild.adapter = adapter
        holder.vb.tvOrderId.text = "${item.ooid}"
        holder.vb.tvTotal.text = "${item.price}"
        holder.vb.ivMore.singleClick {

        }
    }
}