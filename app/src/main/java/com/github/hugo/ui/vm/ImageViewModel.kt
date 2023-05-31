package com.github.hugo.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hugo.api.MainRepository
import com.github.hugo.api.response.HttpResult
import com.github.hugo.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/5/6
 * @project hugo
 * Description:
 **/

@HiltViewModel
class ImageViewModel
@Inject
constructor(private val repository: MainRepository) : ViewModel() {
    private val _responseImages by lazy { MutableLiveData<MutableList<ImageModel>>() }
    val responseImages = _responseImages

    fun getRandomImages() {
        viewModelScope.launch {
            val c = repository.randomPhotos(count = 30)
            if (c is HttpResult.Success) {
                _responseImages.postValue(c.data)
            }
        }
    }
}