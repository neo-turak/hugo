package com.github.hugo.room.entity

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.hugo.api.Constants
import kotlinx.parcelize.Parcelize

    @Keep
    @Parcelize
    @Entity(tableName = Constants.DB_SOFTWARE)
    data class SoftwareEntity(
        @PrimaryKey(autoGenerate = true)
        val uid: Int,
        @ColumnInfo(name = "time")
        val time: String, // 2022-10-18
        @ColumnInfo(name = "title")
        val title: String, // 标题
        @ColumnInfo(name = "url")
        val url: String // 地址
    ) : Parcelable