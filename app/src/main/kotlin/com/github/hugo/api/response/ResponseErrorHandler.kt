package com.github.hugo.api.response

import retrofit2.Response
import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/4/28
 * @project hugo
 * Description:
 **/


inline fun <T> Response<HttpResponse<T>>.responseHandler(
    onSuccess: (T) -> Unit,
    onFailure: (Throwable) -> Unit
) {
    if (this.isSuccessful) {
        val result = this.body()
        if (result?.data != null) {
            onSuccess(result.data)
            return
        }
        result?.msg?.let {
            onFailure(EmptyBodyException(it))
            return
        }
        onFailure(EmptyBodyException("操作失败，请重试！"))
    } else {
        onFailure(NetworkFailureException())
    }
}

inline fun <T> Response<HttpResponse<T>>.responseHandler(
    onSuccess: (T) -> Unit
) {
    if (this.isSuccessful) {
        val result = this.body()
        if (result?.data != null) {
            onSuccess(result.data)
            return
        }
        Timber.e("Empty response body!")
    } else {
        Timber.e("Unsuccessful http request!")
    }
}

inline fun <T> Response<T>.responseDataHandler(
    onSuccess: (T) -> Unit
) {
    if (this.isSuccessful) {
        val result = this.body()
        if (result != null) {
            onSuccess(result)
            return
        }
        Timber.e("Empty response body!")
    } else {
        Timber.e("Unsuccessful http request!")
    }
}