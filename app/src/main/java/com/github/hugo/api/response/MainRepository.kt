package com.github.hugo.api.response

import com.github.hugo.api.ApiService
import com.github.hugo.model.ImageModel
import com.github.hugo.model.ShopAdminModel
import com.github.hugo.model.ShopInfoModel
import com.github.hugo.model.SoftwareModel
import com.github.hugo.model.WaitingOrderBean
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

    override suspend fun shopAdminLogin(
        mobile: String,
        pwd: String
    ): Response<HttpResponse<ShopAdminModel?>> {
        return RetrofitHelper.service.shopAdminLogin(mobile, pwd)
    }

    override suspend fun getShopInfo(shopId: Int): Response<HttpResponse<ShopInfoModel>> {
        return RetrofitHelper.service.getShopInfo(shopId)
    }

    override suspend fun getWaitingOrderDetails(shopId: Int): Response<HttpResponse<WaitingOrderBean>> {
        return RetrofitHelper.service.getWaitingOrderDetails(shopId)
    }
}