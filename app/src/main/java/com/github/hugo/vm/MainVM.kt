package com.github.hugo.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.ApiServiceImpl
import com.github.hugo.model.SoftwareModel
import com.github.hugo.room.db
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@HiltViewModel
class MainVM
@Inject
constructor() : ViewModel() {
    private val _softwareList = MutableLiveData<SoftwareModel>()
    val softwareList = _softwareList

    init {
        getSoftwareList()
    }

    private fun getSoftwareList() {
        viewModelScope.launch {
            val response = ApiServiceImpl().getSoftwareList()
            _softwareList.value = response.body()?.data.also {
                val userDao = db.softwareDao()
                withContext(Dispatchers.IO) {
                    userDao.insertAll(*it!!.softwareList.toTypedArray())
                }
            }
        }
    }
}

