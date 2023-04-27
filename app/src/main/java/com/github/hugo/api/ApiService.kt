package com.github.hugo.api

import com.github.hugo.api.response.HttpResponse
import com.github.hugo.model.SoftwareModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("ghapi")
    suspend fun getSoftwareList(
        @Query("type") type: String = "query",
        @Query("n") n: String = "new"
    ): Response<HttpResponse<SoftwareModel>>
}