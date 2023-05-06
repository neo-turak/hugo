package com.github.hugo.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.hugo.adapter.ImageAdapter
import com.github.hugo.databinding.ActivityImageBinding
import com.github.hugo.decoration.ImageItemDecoration
import com.github.hugo.vm.ImageViewModel
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
class ActivityImage : AppCompatActivity() {
    private val binding by lazy { ActivityImageBinding.inflate(layoutInflater) }
    private val vm: ImageViewModel by viewModels()

    @Inject
    lateinit var adapter: ImageAdapter

    lateinit var itemDecoration: ImageItemDecoration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMain.adapter = adapter
        itemDecoration = ImageItemDecoration()
        binding.rvMain.addItemDecoration(itemDecoration)

        binding.refresh.setOnRefreshListener {
            binding.refresh.isRefreshing = false
            vm.getRandomImages()
        }
        vm.responseImages.observe(this) {
            adapter.setNewInstance(it)
        }
    }
}