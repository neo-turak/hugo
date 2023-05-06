package com.github.hugo.api.response

import com.github.hugo.api.ApiService
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
constructor() : ApiService {
    override suspend fun getSoftwareList(
        type: String,
        n: String
    ): Response<HttpResponse<SoftwareModel>> {
        return RetrofitHelper.service.getSoftwareList(type, n)
    }

    override suspend fun randomPhotos(
        acceptVersion: String,
        authorization: String,
        count: Int
    ): Response<MutableList<ImageModel>> {
        return RetrofitHelper.service.randomPhotos(count = count)
    }
}