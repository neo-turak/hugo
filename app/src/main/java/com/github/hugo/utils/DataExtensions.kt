package com.github.hugo.utils

/**
 * @author 努尔江
 * Created on: 2023/5/4
 * @project AI Astrology
 * Description:
 **/

fun String?.toStringNotNull(holder: String = ""): String {
    this?.let {
        return it
    }
    return holder
}