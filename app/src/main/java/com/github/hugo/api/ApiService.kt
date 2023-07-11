package com.github.hugo.api

import com.github.hugo.api.response.HttpResponse
import com.github.hugo.model.ImageModel
import com.github.hugo.model.ShopAdminModel
import com.github.hugo.model.SoftwareModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("ghapi")
    suspend fun getSoftwareList(
        @Query("type") type: String = "query",
        @Query("n") n: String = "new"
    ): Response<HttpResponse<SoftwareModel>>

    @GET("${Constants.UNSPLASH_URL}/photos/random")
    suspend fun randomPhotos(
        @Header("Accept-Version") acceptVersion: String = "v1",
        @Header("Authorization") authorization: String = "Client-ID yI9uzM249kARnvRXZMZW-VORzUFSzHGi5u0CLYxHeC4",
        @Query("count") count: Int
    )
            : Response<MutableList<ImageModel>>

    @GET("${Constants.MAIN_URL}/api/shop/admin/login")
    suspend fun shopAdminLogin(
        @Query("mobile") mobile: String,
        @Query("password") pwd: String
    ): Response<HttpResponse<ShopAdminModel?>>
}
