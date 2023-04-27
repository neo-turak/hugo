package com.github.hugo

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

 lateinit var application:Application

 @HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        SoLoader.init(this, false)
        //Timber
        initTimber()
        //flipper init
        initFlipper()
    }

    private fun initTimber(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initFlipper(){
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            //layout
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            //database
            client.addPlugin(DatabasesFlipperPlugin(this))
            //leak
            client.addPlugin(LeakCanary2FlipperPlugin())
            //network
            client.addPlugin(NetworkFlipperPlugin())
            //shared-preferences
            client.addPlugin(SharedPreferencesFlipperPlugin(this))

            client.start()
        }
    }
}