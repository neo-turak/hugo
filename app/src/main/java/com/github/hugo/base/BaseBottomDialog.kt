package com.github.hugo.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.github.hugo.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 *  * @author 努尔江
 * Created on: 2023/5/10
 * @param VB ViewBinding 对象。
 * @注意 父布局必须是FrameLayout否则会出现高度自适应的情况。
 * @see show 方法。
 */
abstract class BaseBottomDialog<VB : ViewBinding> : BottomSheetDialogFragment() {
    private var vb: VB? = null
    val binding by lazy {   vb!! }
    open fun setDimValue():Float{
        return  0.1f
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.behavior.isDraggable = false  // 设置禁止拖拽
        dialog.window?.setDimAmount(setDimValue())
        setStyle(STYLE_NO_TITLE, R.style.BottomSheetDialog)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.run {
            // 取消默认的背景色
            try {
                // hack bg color of the BottomSheetDialog
                val parent = requireView().parent as ViewGroup
                parent.setBackgroundResource(R.color.transparent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
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

    fun show(fm:FragmentManager) {
        this.show(fm, this.javaClass.simpleName)
    }

    fun show(fragmentActivity: FragmentActivity){
        this.show(fragmentActivity.supportFragmentManager,this.javaClass.simpleName)
    }

    protected abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    protected abstract fun initView(savedInstanceState: Bundle?)

}