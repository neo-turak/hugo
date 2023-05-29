package com.github.hugo.ui.activity

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import coil.load
import com.github.hugo.base.BaseActivity
import com.github.hugo.databinding.ActivityMarcoBinding
import com.github.neoturak.common.singleClick
import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/5/29
 * @project hugo
 * Description:
 **/

class ActivityMarco: BaseActivity<ActivityMarcoBinding>(){
    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(2)){
        if (it!= null){
            Timber.e("URI——-》${it[0]}")
            binding.image.load(it[0]){
                this.crossfade(true)
            }
        }else{
            Timber.e("URI——-》no")
        }
    }

    override fun getViewBinding() = ActivityMarcoBinding.inflate(layoutInflater)

    override fun initViews() {
        binding.btnCheck.singleClick {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }

    }

    private fun requestMediaPermission() {

    }
}