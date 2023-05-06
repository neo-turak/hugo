package com.github.hugo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.hugo.activity.ActivityImage
import com.github.hugo.adapter.MainAdapter
import com.github.hugo.databinding.ActivityMainBinding
import com.github.hugo.decoration.MainItemDecoration
import com.github.hugo.model.MyAppInfo
import com.github.hugo.utils.LunarMoonUtils
import com.github.hugo.vm.MainViewModel
import com.github.neoturak.common.singleClick
import com.github.neoturak.common.startActivity
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
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
            binding.srl.isRefreshing = false
            adapter.addData(it.softwareList)
            Timber.e("数据--》${it.softwareList.size}")
        }
        //json
        val str = "{\"appId\":102210032}"
        val json = JSONObject(str)
        val appId1 = json.optInt("appId")
        val rm = Gson().fromJson(str, MyAppInfo::class.java)
        val appId2 = rm.appId
        //moon
        val moon = LunarMoonUtils.monthData(2023, 5, 1, 30)
       // Timber.e("Moon-->${moon}")
        moon.forEachIndexed { index, i ->
            val natural = index +1
            when (i) {
                0 -> Timber.e("${natural}:New Moon")
                2 -> Timber.e("${natural}:Waxing Crescent")
                7 -> Timber.e("${natural}:First Quarter")
                9 -> Timber.e("${natural}:Waxing Gibbous")
                14 -> Timber.e("${natural}:Full Moon")
                16 -> Timber.e("${natural}:Waning Gibbous")
                21 -> Timber.e("${natural}:Third Quarter")
                24 -> Timber.e("${natural}:Waning Crescent")
                else->Timber.e("$natural")
            }
        }
        binding.srl.setOnRefreshListener {
            binding.srl.isRefreshing = true
            vm.getSoftware()
        }

        binding.buttonImage.singleClick {
            startActivity<ActivityImage>()
        }
    }
}