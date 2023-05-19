package com.github.hugo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
        initViews()
    }

    abstract fun getViewBinding(): VB

    abstract fun initViews()

     fun killMySelf() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
