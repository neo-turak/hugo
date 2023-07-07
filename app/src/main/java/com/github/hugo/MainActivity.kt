package com.github.hugo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.hugo.adapter.HomePageAdapter
import com.github.hugo.databinding.ActivityMainBinding
import com.github.hugo.vm.MainViewModel
import com.github.neoturak.ui.immersiveStatusBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()
    private val pageAdapter by lazy { HomePageAdapter(supportFragmentManager, lifecycle) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        immersiveStatusBar()
        binding.viewPager2.adapter = pageAdapter
        binding.viewPager2.isUserInputEnabled = false
        binding.bnvMenu.setOnItemSelectedListener {
            return@setOnItemSelectedListener when (it.itemId) {
                R.id.navigation_home -> {
                    binding.viewPager2.currentItem = 0
                    true
                }

                R.id.navigation_vip -> {
                    binding.viewPager2.currentItem = 1
                    true
                }

                R.id.navigation_order -> {
                    binding.viewPager2.currentItem = 2
                    true
                }

                R.id.navigation_mine -> {
                    binding.viewPager2.currentItem = 3
                    true
                }

                else -> false
            }
        }

    }
}