package com.github.hugo.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.MainRepository
import com.github.hugo.api.response.responseHandler
import com.github.hugo.model.SoftwareModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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

    private val _softwareList: MutableLiveData<SoftwareModel> by lazy { MutableLiveData<SoftwareModel>() }
    val softwareList = _softwareList

    init {
      //  getSoftware()
    }
     fun getSoftware() {
        viewModelScope.launch {
            mainRepository.getSoftwareList().responseHandler {
                _softwareList.postValue(it)
            }
        }
    }
}

