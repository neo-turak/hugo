package com.github.hugo.base

import android.view.View
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

class VBViewHolder<VB : ViewBinding>(val vb: VB, view: View) : BaseViewHolder(view)
