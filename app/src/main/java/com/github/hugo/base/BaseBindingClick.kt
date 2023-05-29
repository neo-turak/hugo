package com.github.hugo.base

import android.view.View

/**
 * @author 努尔江
 * Created on: 2023/5/25
 * @project hugo
 * Description:
 **/
interface BaseBindingClick {
    fun addChildClickViews(vararg views: View)
    fun addChildLongClickViews(vararg views: View)
}