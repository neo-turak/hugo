package com.github.hugo.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.github.hugo.R
import com.github.neoturak.common.dp2px
import com.github.neoturak.ui.immersiveStatusBar
import com.github.neoturak.ui.statusHeight

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    private var compatView: View? = null
     private val loadingView by lazy {
         LottieAnimationView(this).apply {
             this.repeatCount = LottieDrawable.INFINITE
             this.setAnimation(R.raw.loading)
         }

     }
    private val loadingDialog by lazy {
        AlertDialog.Builder(this)
            .setView(loadingView)
            .create()
    }
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
        initViews()
        if (darkStatusBar) {
            immersiveStatusBar()
        }
        if (compatView != null) {
            val layoutParams = compatView!!.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.topMargin = statusHeight + dp2px(10)
            compatView!!.layoutParams = layoutParams
        }
    }

    fun showLoading(){
        if(!loadingDialog.isShowing){
        loadingDialog.show()
            loadingView.playAnimation()
        }
    }

    fun hideLoading(){
        if (loadingDialog.isShowing){
            loadingView.cancelAnimation()
            loadingDialog.dismiss()
        }
    }

    /**
     * 是否要全屏。
     */
    protected var darkStatusBar = true

    /**
     * 要适配挖孔屏的viewGroup
     */
    protected fun setCompatView(v: View) {
        this.compatView = v
    }
    abstract fun getViewBinding(): VB

    /**
     * view 事件初始化逻辑。
     */
    abstract fun initViews()

    fun killMySelf() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
