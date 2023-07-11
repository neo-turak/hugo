package com.github.hugo.api.response

/**
 * @author 努尔江
 * Created on: 2023/5/4
 * @project hugo
 * Description:
 **/

class EmptyBodyException(private val msg: String) : Exception() {

    override val message: String
        get() = msg
}