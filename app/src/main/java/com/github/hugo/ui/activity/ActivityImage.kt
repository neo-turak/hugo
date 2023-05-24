package com.github.hugo.ui.activity

import androidx.activity.viewModels
import com.github.hugo.base.BaseActivity
import com.github.hugo.databinding.ActivityImageBinding
import com.github.hugo.ui.adapter.ImageAdapter
import com.github.hugo.ui.decoration.ImageItemDecoration
import com.github.hugo.ui.vm.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/5/6
 * @project hugo
 * Description:
 **/

//Access--yI9uzM249kARnvRXZMZW-VORzUFSzHGi5u0CLYxHeC4
//Secret--BSO1ySWs3wzupaOSdRAtnNp5rZcFu6zgRTTgvHPCbv4

@AndroidEntryPoint
class ActivityImage : BaseActivity<ActivityImageBinding>() {

    private val vm: ImageViewModel by viewModels()

    @Inject
    lateinit var adapter: ImageAdapter

    @Inject
    lateinit var itemDecoration: ImageItemDecoration

    override fun getViewBinding() = ActivityImageBinding.inflate(layoutInflater)


    override fun initViews() {
        binding.rvMain.adapter = adapter
        binding.rvMain.addItemDecoration(itemDecoration)

        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            
        }
        binding.refresh.setOnRefreshListener {
            binding.refresh.isRefreshing = false
            vm.getRandomImages()
        }

        vm.responseImages.observe(this) {
            adapter.setNewInstance(it)
        }
    }
}