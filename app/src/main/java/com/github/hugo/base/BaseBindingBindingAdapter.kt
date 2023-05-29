package com.github.hugo.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import java.lang.reflect.ParameterizedType



abstract class BaseBindingBindingAdapter<VB : ViewBinding, T>(data: MutableList<T>? = null) :
    BaseQuickAdapter<T, VBBaseViewHolder<VB>>(0, data), BaseBindingClick {

    //重写返回自定义 ViewHolder
    @Suppress("UNCHECKED_CAST")
    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): VBBaseViewHolder<VB> {
        //这里为了使用简洁性，使用反射来实例ViewBinding
        val vbClass: Class<VB> =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val inflate = vbClass.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        val mBinding =
            inflate.invoke(null, LayoutInflater.from(parent.context), parent, false) as VB
        return VBBaseViewHolder(mBinding)
    }

   override fun addChildClickViews(vararg views: View) {
        for (view in views) {
            addChildClickViewIds(view.id)
        }
    }

   override fun addChildLongClickViews(vararg views: View) {
        for (view in views) {
            addChildLongClickViewIds(view.id)
        }
    }
}