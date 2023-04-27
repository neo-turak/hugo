package com.github.hugo.api.response

import com.github.hugo.api.ApiService
import com.github.hugo.model.SoftwareModel
import retrofit2.Response

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

class ApiServiceImpl : ApiService {
    override suspend fun getSoftwareList(
        type: String,
        n: String
    ): Response<HttpResponse<SoftwareModel>> {
        return RetrofitHelper.service.getSoftwareList(type, n)
    }
}