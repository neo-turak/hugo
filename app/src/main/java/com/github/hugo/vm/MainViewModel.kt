package com.github.hugo.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.response.MainRepository
import com.github.hugo.api.response.responseHandler
import com.github.hugo.model.AppInfoModel
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
    val multiList = mutableListOf(
            AppInfoModel("https://images.unsplash.com/photo-1551024559-d69bcf67d8d1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=994&q=80",1),
            AppInfoModel("In this example, the getFirstElement() function is a generic function that takes a List of type T and returns the first element of the list. The type parameter T is declared before the function name in angle brackets, and is used to define the type of the list elements and the return type of the function.",0),
            AppInfoModel("https://images.unsplash.com/photo-1565134140207-8eeb724d48b0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",1),
            AppInfoModel("用惋惜地造句 这次没能取得年纪第一，大家都很惋惜。 他惋惜地说：“气球破了!” 妈妈惋惜地对我说:“这次考试,你要是在认真点就好了。” 队长惋惜地说：我们尽了最大的力量来抢救伤员，但最终却无能为力了。 拔河比赛输了，老师惋惜地说：“我们必定在下次…",0),
            AppInfoModel("https://images.unsplash.com/photo-1547656100-a8aae50628ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=985&q=80",1),
            AppInfoModel("用甚至造句 1、他委屈地哭了两天，甚至连饭都没吃。 2、不想他真的做到了，甚至还考了校第一。 3、听同学说，某地垃圾成堆，环境受到影响，甚至连猫狗都不去。 4、他不仅骗了大家的钱，甚至连手机也都骗走了。 6、她在我困难时伸出了援助之手，可我甚至不知道她的名",0),
    )
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

