package com.github.hugo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.github.hugo.R
import com.github.hugo.adapter.HomeBannerAdapter
import com.github.hugo.adapter.HomeMenuAdapter
import com.github.hugo.databinding.FragmentHomeBinding
import com.github.hugo.model.HomeMenuModel
import com.youth.banner.indicator.CircleIndicator

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/6 上午12:25
 *@project  hugo
 *Think Twice, Code Once!
 */
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding by lazy { _binding!! }
    private val bannerAdapter by lazy { HomeBannerAdapter() }
    private val menuAdapter by lazy { HomeMenuAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val indicator = CircleIndicator(requireContext())
        binding.banner.addBannerLifecycleObserver(this)
            .setAdapter(bannerAdapter)
            .indicator = indicator
        menuAdapter.setNewInstance(
            mutableListOf(
                HomeMenuModel(0, R.drawable.ic_home_menu_pizza, "西餐"),
                HomeMenuModel(0, R.drawable.ic_home_menu_fastfood, "快餐"),
                HomeMenuModel(0, R.drawable.ic_home_menu_breakfast, "早餐"),
                HomeMenuModel(0, R.drawable.ic_home_menu_cake, "蛋糕"),
                HomeMenuModel(0, R.drawable.ic_home_menu_flowers, "鲜花"),
                HomeMenuModel(0, R.drawable.ic_home_menu_supermarket, "超市"),
                HomeMenuModel(0, R.drawable.ic_home_menu_charger, "手机充电"),
                HomeMenuModel(0, R.drawable.ic_home_menu_chargetool, "充电宝")
            )
        )
        binding.rvMenu.adapter = menuAdapter
        ///
        binding.ivStore1.load("https://media.altphotos.com/cache/images/2017/02/22/16/752/salmon-toasts-restaurant.jpg")
        binding.ivStore2.load("https://media.altphotos.com/cache/images/2017/08/23/08/752/salad-mushrooms-meal.jpg")

        binding.ivRecommend1.load("https://img1.baidu.com/it/u=1130284450,2967175022&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=809")
        binding.ivRecommend2.load("https://img2.baidu.com/it/u=2866281629,1984819473&fm=253&fmt=auto&app=138&f=JPEG?w=723&h=500")
        binding.ivRecommend3.load("https://img0.baidu.com/it/u=3314032808,2980710415&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500")
    }
}