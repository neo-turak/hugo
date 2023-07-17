package com.github.hugo.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.MainRepository
import com.github.hugo.api.response.responseHandler
import com.github.hugo.ds.dataStore
import com.github.hugo.ds.dsShopId
import com.github.hugo.model.ShopInfoModel
import com.github.hugo.model.WaitingOrderBean
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val application: Application,
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _shopInfoModel = MutableLiveData<ShopInfoModel>()
    private val _waitingOrderModel = MutableLiveData<WaitingOrderBean>()
    val msg = MutableLiveData<String>()
    val shopInfoModel = _shopInfoModel
    val waitingOrderModel = _waitingOrderModel

    init {
        getShopInfo()
    }

    fun getShopInfo() {
        viewModelScope.launch {
            val id = application.dataStore.data.map { value ->
                value[dsShopId]
            }
            mainRepository.getShopInfo(id.first()!!).responseHandler(onSuccess = {
                _shopInfoModel.postValue(it)
            }, onFailure = {
                msg.postValue(it.message)
            })
        }
    }

    fun getWaitingOrderDetails() {
        viewModelScope.launch {
            val id = application.dataStore.data.map { value ->
                value[dsShopId]
            }
            mainRepository.getWaitingOrderDetails(id.first()!!).responseHandler(onSuccess = {
                _waitingOrderModel.postValue(it)
                Timber.e("大小-->${it.size}")
            }, onFailure = {
                Timber.e("大小-->${it.message}")
            })
        }
    }
}

