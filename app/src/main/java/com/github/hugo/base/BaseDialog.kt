package com.github.hugo.base

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.github.hugo.R

/**
 *  * @author 努尔江
 * Created on: 2023/5/10
 * @param VB ViewBinding 对象。
 * @注意 父布局必须是FrameLayout否则会出现高度自适应的情况。
 * @see show 方法。
 */

abstract class BaseDialog<VB : ViewBinding> : DialogFragment() {
    private var vb: VB? = null
    val binding by lazy { vb!! }
    open fun setDimValue(): Float {
        return 0.1f
    }

    override fun onStart() {
        super.onStart()
        dialog!!.window!!.setGravity(Gravity.CENTER)
        dialog!!.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog!!.window!!.decorView.setBackgroundResource(R.color.transparent)
        dialog!!.window!!.setDimAmount(setDimValue())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = getViewBinding(inflater, container)
        initView(savedInstanceState)
        return vb?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    fun show(fm: FragmentManager) {
        this.show(fm, this.javaClass.simpleName)
    }

    fun show(fragmentActivity: FragmentActivity) {
        this.show(fragmentActivity.supportFragmentManager, this.javaClass.simpleName)
    }

    protected abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    protected abstract fun initView(savedInstanceState: Bundle?)

}