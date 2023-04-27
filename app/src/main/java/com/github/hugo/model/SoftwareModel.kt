package com.github.hugo.model


import android.os.Parcelable
import androidx.annotation.Keep
import com.github.hugo.room.SoftwareEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SoftwareModel(
    val count: Int, // 30
    @SerializedName("list")
    val softwareList: List<SoftwareEntity>
) : Parcelable