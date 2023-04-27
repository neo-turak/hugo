package com.github.hugo.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.MainRepository
import com.github.hugo.model.SoftwareModel
import com.github.hugo.room.AppDatabase
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
class MainViewModel
@Inject constructor(
   private val application: Application,
    private val mainRepository: MainRepository) : ViewModel() {

    private val _softwareList: MutableLiveData<SoftwareModel> by lazy { MutableLiveData<SoftwareModel>() }
    val softwareList = _softwareList

    init {
        getSoftware()
    }

    private fun getSoftware() {
        viewModelScope.launch {
            kotlin.runCatching {
                mainRepository.getSoftwareList().also {
                    if (it.isSuccessful && it.body() != null && it.body()!!.data != null) {
                        _softwareList.postValue(it.body()!!.data!!)
                        withContext(Dispatchers.IO) {
                            AppDatabase.getInstance(application).softwareDao()
                                .insertAll(*it.body()!!.data!!.softwareList.toTypedArray())
                        }
                    }
                }
            }
        }
    }
}

