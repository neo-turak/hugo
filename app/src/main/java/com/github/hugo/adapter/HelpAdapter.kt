package com.github.hugo.adapter

import android.view.ViewGroup
import com.chad.library.adapter.base.binder.BaseItemBinder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.hugo.model.MyAppInfo

/**
 * @author 努尔江
 * Created on: 2023/5/11
 * @project hugo
 * Description:
 **/

class HelpAdapter : BaseItemBinder<MyAppInfo, BaseViewHolder>() {
    override fun convert(holder: BaseViewHolder, data: MyAppInfo) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

    }
}