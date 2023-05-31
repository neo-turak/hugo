package com.github.hugo.api

import com.github.hugo.api.response.HttpResponse
import com.github.hugo.api.response.HttpResult
import com.github.hugo.model.ImageModel
import com.github.hugo.model.SoftwareModel
import retrofit2.Response
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

class MainRepository
@Inject
constructor() {
    suspend fun getSoftwareList(): Response<HttpResponse<SoftwareModel>> {
        return RetrofitHelper.service.getSoftwareList()
    }

    suspend fun randomPhotos(count: Int): HttpResult<MutableList<ImageModel>> {
        return try {
            val response = RetrofitHelper.service.randomPhotos(count = count)
            if (response.isSuccessful) {
                val softwareList = response.body()
                HttpResult.Success(softwareList!!)
            } else {
                val errorBody = response.errorBody()?.toString()
                HttpResult.Error(Exception(errorBody))
            }
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }
}

