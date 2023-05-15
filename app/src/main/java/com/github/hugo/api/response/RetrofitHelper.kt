package com.github.hugo.api.response

import com.ayvytr.okhttploginterceptor.LoggingInterceptor
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.github.hugo.api.ApiService
import com.github.hugo.api.Constants
import com.github.hugo.networkFlipperPlugin
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

object RetrofitHelper {
    private val loggingInterceptor = LoggingInterceptor()
    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    private val gson = GsonBuilder()
        .serializeNulls()
        .setLenient()
        .enableComplexMapKeySerialization()
        .create()
    private val gsonConverterFactory = GsonConverterFactory.create(gson)

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
    var service: ApiService = retrofit.create(ApiService::class.java)
}