package com.github.hugo.api.response

/**
 * @author 努尔江
 * Created on: 2023/5/4
 * @project hugo
 * Description:
 **/

class NetworkFailureException : Exception() {
    override val message: String
        get() = "Network failure exception"
}