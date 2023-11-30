package com.github.hugo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@HiltViewModel
open class BaseViewModel
@Inject
constructor(application: Application) : AndroidViewModel(application) {
    protected val context
        get() = getApplication<Application>()
}