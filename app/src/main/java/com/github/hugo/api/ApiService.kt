package com.github.hugo.api

import com.github.hugo.api.response.HttpResponse
import com.github.hugo.model.ImageModel
import com.github.hugo.model.ShopAdminModel
import com.github.hugo.model.ShopInfoModel
import com.github.hugo.model.SoftwareModel
import com.github.hugo.model.WaitingOrderBean
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
    ): Response<MutableList<ImageModel>>

    @GET("${Constants.MAIN_URL}/api/shop/admin/login")
    suspend fun shopAdminLogin(
        @Query("mobile") mobile: String,
        @Query("password") pwd: String
    ): Response<HttpResponse<ShopAdminModel?>>

    @GET("${Constants.MAIN_URL}/api/shop/shop/details")
    suspend fun getShopInfo(@Query("id") shopId: Int): Response<HttpResponse<ShopInfoModel>>

    @GET("${Constants.MAIN_URL}/api/shop/order/list")
    suspend fun getWaitingOrderDetails(@Query("shopId") shopId: Int): Response<HttpResponse<WaitingOrderBean>>
}
