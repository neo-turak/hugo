package com.github.hugo.model

import com.chad.library.adapter.base.entity.MultiItemEntity

data class AppInfoModel(val content: String, override val itemType: Int) : MultiItemEntity
