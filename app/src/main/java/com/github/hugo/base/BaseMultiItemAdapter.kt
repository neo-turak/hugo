package com.github.hugo.base

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @author 努尔江
 * Created on: 2023/5/12
 * @project hugo
 * Description:
 **/

abstract class BaseMultiItemAdapter<T : MultiItemEntity> :
    BaseMultiItemQuickAdapter<T, VBBaseViewHolder<ViewBinding>>() {
    private val bindings: SparseArray<(LayoutInflater, ViewGroup, Boolean) -> ViewBinding> by lazy(
        LazyThreadSafetyMode.NONE
    ) {
        SparseArray<(LayoutInflater, ViewGroup, Boolean) -> ViewBinding>()
    }

    fun addViewBinding(type:Int,inflate:(LayoutInflater,ViewGroup,Boolean)->ViewBinding){
        bindings.put(type,inflate)
    }

    override fun onCreateDefViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VBBaseViewHolder<ViewBinding> {
        val inflate = bindings.get(viewType)
        require(inflate!=null) {"ViewType: $viewType found ViewBinding, please use addViewbinding() first!"}
        val viewBinding = inflate(LayoutInflater.from(parent.context),parent,false)
        return  VBBaseViewHolder(viewBinding)
    }

}