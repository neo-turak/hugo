package com.github.hugo.base

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.github.hugo.databinding.CustomToastBinding
import com.github.neoturak.common.dp2px

class CustomToast {

    private var title: String = ""
    private var duration: Int = Toast.LENGTH_SHORT
    private lateinit var context: Context
    private lateinit var binding: CustomToastBinding
    private lateinit var inflater: LayoutInflater

    private constructor()
    constructor(context: Context, title: String, duration: Int = Toast.LENGTH_SHORT) : this() {
        this.title = title
        initToast(context, duration)
    }

    constructor(context: Context, title: Int, duration: Int = Toast.LENGTH_SHORT) : this() {
        this.title = context.getString(title)
        initToast(context, duration)
    }

    private fun initToast(context: Context, duration: Int) {
        this.context = context
        this.duration = duration
        inflater = LayoutInflater.from(context)
        binding = CustomToastBinding.inflate(inflater)
    }

    fun show() {
        val toast = Toast(context)
        toast.duration = duration
        binding.root.text = title
        toast.setGravity(Gravity.BOTTOM, 0, context.dp2px(72))
        toast.view = binding.root
        toast.show()
    }
}