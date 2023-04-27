package com.github.hugo

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.hugo.adapter.MainAdapter
import com.github.hugo.databinding.ActivityMainBinding
import com.github.hugo.decoration.MainItemDecoration
import com.github.hugo.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()
    @Inject
    lateinit var adapter: MainAdapter
    @Inject
    lateinit var decoration: MainItemDecoration
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(decoration)
        vm.softwareList.observe(this) {
            adapter.addData(it.softwareList)
            Timber.e("数据--》${it.softwareList.size}")
        }

        var fadeTransaction = TransitionInflater.from(this)
            .inflateTransition(R.transition.fade_transition)
    }
}