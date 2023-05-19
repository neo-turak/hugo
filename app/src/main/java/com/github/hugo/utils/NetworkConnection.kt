package com.github.hugo.utils


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import androidx.lifecycle.LiveData

/**
 * 网络状态管理。
 * 监听网络状态变化。
 */

@Suppress("DEPRECATION")
class NetworkConnection(private val context: Context) : LiveData<Boolean>() {

    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private lateinit var networkConnectionCallback: ConnectivityManager.NetworkCallback

    override fun onActive() {
        super.onActive()

        updateNetworkConnection()
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                connectivityManager.registerDefaultNetworkCallback(connectivityManagerCallback())
            }
            else -> {
                context.registerReceiver(
                    networkReceiver,
                    IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                )
            }
        }
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(connectivityManagerCallback())
    }

    private fun connectivityManagerCallback(): ConnectivityManager.NetworkCallback {

        networkConnectionCallback = object : ConnectivityManager.NetworkCallback() {

            override fun onLost(network: Network) {
                super.onLost(network)
                postValue(false)
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                postValue(true)
            }
        }
        return networkConnectionCallback
    }

    private fun updateNetworkConnection() {
        val activeNetworkConnection: NetworkInfo? = connectivityManager.activeNetworkInfo
        postValue(activeNetworkConnection?.isConnected == true)
    }

    private val networkReceiver= object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            updateNetworkConnection()
        }
    }
}


/** Method to check network connectivity in the Splash Activity **/
 fun Context.checkConnectivity(): Boolean {
    // here we are getting the connectivity service from connectivity manager
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    // Getting network Info
    // give Network Access Permission in Manifest
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    // isConnected is a boolean variable
    // here we check if network is connected or is getting connected
    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
}