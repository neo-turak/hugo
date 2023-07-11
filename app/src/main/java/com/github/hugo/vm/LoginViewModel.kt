package com.github.hugo.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.MainRepository
import com.github.hugo.api.response.responseHandler
import com.github.hugo.ds.saveAdminInfo
import com.github.hugo.helper.toJson
import com.github.hugo.model.ShopAdminModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/11 下午2:10
 *@project  hugo
 *Think Twice, Code Once!
 */
@HiltViewModel
class LoginViewModel
@Inject
constructor(
    private val application: Application,
    private val mainRepository: MainRepository
) : ViewModel() {
    val shopAdminModel = MutableLiveData<ShopAdminModel>()
    val msg = MutableLiveData<String>()
    val showPwd = MutableLiveData(false)
    fun shopAdminLogin(mobile: String, pwd: String) {
        viewModelScope.launch {
            mainRepository.shopAdminLogin(mobile, pwd).responseHandler(
                onSuccess = {
                    if (it != null) {
                        write2Local(it)
                        shopAdminModel.postValue(it)
                    } else {
                        msg.postValue("登录失败")
                    }
                }, onFailure = {
                    msg.postValue(it.message)
                })
        }
    }

    private fun write2Local(shopAdminModel: ShopAdminModel) {
        viewModelScope.launch {
            application.saveAdminInfo(shopAdminModel.toJson())
        }
    }

    fun changeEye() {
        showPwd.postValue(showPwd.value!!.not())
    }
}