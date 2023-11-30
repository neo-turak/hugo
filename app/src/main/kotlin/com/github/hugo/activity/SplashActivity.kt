package com.github.hugo.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.github.hugo.MainActivity
import com.github.hugo.databinding.ActivitySplashBinding
import com.github.hugo.ds.getAdminInfo
import com.github.neoturak.ui.immersiveStatusBar
import com.github.neoturak.ui.startActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/5 下午10:47
 *@project  hugo
 *Think Twice, Code Once!
 */
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ActivitySplashBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
        immersiveStatusBar()
        zoomAndSmall()
    }

    private fun zoomAndSmall() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(200L)
            zs()
            counter()
        }
    }

    private fun zs() {
        val scaleAnimation =
            ScaleAnimation(
                1.0f, 1.2f, 1.0f, 1.2f,
                binding.siv.width / 2f,
                binding.siv.height / 2f
            )
        scaleAnimation.duration = 1000L
        scaleAnimation.repeatMode = Animation.REVERSE
        scaleAnimation.repeatCount = 4
        binding.siv.startAnimation(scaleAnimation)
    }

    private fun counter() {
        val valueAnimation = ValueAnimator.ofInt(0, 100)
        valueAnimation.duration = 4000L
        var id = 0
        CoroutineScope(Dispatchers.IO).launch {
            val result = this@SplashActivity.getAdminInfo()
            if (result != null) {
                id = result.shopId
            }
        }
        valueAnimation.interpolator = AccelerateInterpolator()
        valueAnimation.addUpdateListener { animator ->
            val animatedValue = animator.animatedValue as Int
            binding.progressBar.progress = animatedValue
            binding.tvProgress.text = "${animatedValue}%"
            if (animatedValue == 100) {
                valueAnimation.cancel()
                binding.siv.clearAnimation()
                if (id == 0) {
                    startActivity<LoginActivity>()
                } else {
                    startActivity<MainActivity>()
                }
                finish()
            }
        }
        valueAnimation.start()
    }
}