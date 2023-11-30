package com.github.hugo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.hugo.fragment.HomeFragment
import com.github.hugo.fragment.MineFragment
import com.github.hugo.fragment.order.OrderFragment

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/6 上午12:22
 *@project  hugo
 *Think Twice, Code Once!
 */
class HomePageAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    private val fragments by lazy {
        mutableListOf(HomeFragment(), OrderFragment(), MineFragment())
    }

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}