package com.github.hugo.model

import com.chad.library.adapter.base.entity.MultiItemEntity

data class MyAppInfo(val appId: Int, override val itemType: Int) : MultiItemEntity
