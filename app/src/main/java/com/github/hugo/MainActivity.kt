package com.github.hugo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.hugo.activity.ActivityImage
import com.github.hugo.adapter.HelpAdapter
import com.github.hugo.databinding.ActivityMainBinding
import com.github.hugo.decoration.MainItemDecoration
import com.github.hugo.model.AppInfoModel
import com.github.hugo.vm.MainViewModel
import com.github.neoturak.common.singleClick
import com.github.neoturak.common.startActivity
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()

    @Inject
    lateinit var adapter: HelpAdapter

    @Inject
    lateinit var decoration: MainItemDecoration
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter.setNewInstance(vm.multiList)
        adapter.addChildClickViewIds(R.id.image)
        adapter.setOnItemChildClickListener { adapter, _, position ->
            val dt = adapter.data[position] as AppInfoModel
            Toasty.success(this,dt.content).show()
        }

        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(decoration)

        vm.softwareList.observe(this) {
            binding.srl.isRefreshing = false

            Timber.e("数据--》${it.softwareList.size}")
        }
        //json
        val str = "{\"itemType\":102210032}"
        val json = JSONObject(str)
        val appId1 = json.optInt("itemType")
        val rm = Gson().fromJson(str, AppInfoModel::class.java)
        val appId2 = rm.itemType
        Timber.e("数据--->${appId1}  $appId2")
        binding.srl.setOnRefreshListener {
            binding.srl.isRefreshing = true
            vm.getSoftware()
        }
        binding.buttonImage.singleClick {
            startActivity<ActivityImage>()
           //HelperDialog().show(this)
           // ConfirmDialog().show(this)
         //   NameInputDialog.instance().show(supportFragmentManager,NameInputDialog::class.java.simpleName)
        }
    }
}