package com.github.hugo.model

data class ShopInfoModel(
    val address: String,
    val altitude: Double,
    val id: Int,
    val longitude: Double,
    val name: String,
    val ownerId: Int,
    val primaryType: String,
    val status: Int,
    val type: String,
    val workEnd: Int,
    val workStart: Int,
    val bgImage: String,
    val intro: String
)