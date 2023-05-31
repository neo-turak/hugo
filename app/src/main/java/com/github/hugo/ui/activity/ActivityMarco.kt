package com.github.hugo.ui.activity

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.BitmapDrawable
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import com.github.hugo.base.BaseActivity
import com.github.hugo.databinding.ActivityMarcoBinding
import com.github.neoturak.common.dp2px
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/5/29
 * @project hugo
 * Description:
 **/

class ActivityMarco : BaseActivity<ActivityMarcoBinding>() {

    override fun getViewBinding() = ActivityMarcoBinding.inflate(layoutInflater)
    var dw: Bitmap? = null
    override fun initViews() {
        darkStatusBar = true
        setCompatView(binding.btnCheck)

        val request = ImageRequest.Builder(this)
            .data("https://img.freepik.com/free-photo/fuji-mountain-kawaguchiko-lake-morning-autumn-seasons-fuji-mountain-yamanachi-japan_335224-102.jpg?w=2000&t=st=1685437038~exp=1685437638~hmac=17b99e6f23d27e0b88ce26d047af9f9b7d6554fa1583765593edab227d67383a")
            .target(
                onStart = { placeholder ->
                    Timber.e("触发了开始！")
                    // Handle the placeholder drawable.
                },
                onSuccess = { result ->
                    Timber.e("触发了成功！")
                    binding.image.load(result)
                    result as BitmapDrawable
                    dw = result.bitmap
                },
                onError = { error ->
                    Timber.e("触发了错误！")
                }
            )
            .allowHardware(false)
            .build()
        this.imageLoader.enqueue(request)
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            cutPentagon(dw!!)
        }
    }


    private fun cutTriangle(bitmap: Bitmap) {
        val triangleWidth = bitmap.width / 8
        val triangleHeight = bitmap.height / 8

        val output = Bitmap.createBitmap(triangleWidth, triangleHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val path = Path()
        path.moveTo(0f, triangleHeight.toFloat())
        path.lineTo(triangleWidth.toFloat(), triangleHeight.toFloat())
        path.lineTo(triangleWidth / 2f, 0f)
        path.close()

        val paint = Paint()
        paint.isAntiAlias = true
        canvas.drawPath(path, paint)
        val paintXferMode = Paint()
        paintXferMode.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(bitmap, 0f, 0f, paintXferMode)
        if (output != null) {
            binding.image1.load(output)
        } else {
            Timber.e("--->output is null")
        }
    }

    private fun cutRectangle(bitmap: Bitmap) {
        val cls = dp2px(40f)
        val output = Bitmap.createBitmap(cls.toInt(), cls.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f,cls )
        path.lineTo(cls, cls)
        path.lineTo(cls, 0f)
        path.close()

        val paint = Paint()
        paint.isAntiAlias = true
        canvas.drawPath(path, paint)
        val paintXferMode = Paint()
        paintXferMode.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(bitmap, 0f, 0f, paintXferMode)
        if (output != null) {
            binding.image1.load(output)
        } else {
            Timber.e("--->output is null")
        }
    }

    fun cutPentagon(bitmap: Bitmap) {
        val pentagonWidth = bitmap.width / 2
        val pentagonHeight = bitmap.height / 2

        val output = Bitmap.createBitmap(pentagonWidth, pentagonHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val path = createPentagonPath(pentagonWidth, pentagonHeight)

        val paint = Paint()
        paint.isAntiAlias = true

        canvas.drawPath(path, paint)

        val paintXferMode = Paint()
        paintXferMode.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(bitmap, 0f, 0f, paintXferMode)
        if (output!= null){
            binding.image1.load(output)
        }
    }

    fun createPentagonPath(width: Int, height: Int): Path {
        val path = Path()

        val centerX = width / 2f
        val centerY = height / 2f

        val radius = width.coerceAtMost(height) / 2f

        val angle = Math.PI * 2 / 5 // Angle between each point on the pentagon
        val startPointX = centerX + radius

        path.moveTo(startPointX, centerY) // Move to the starting point

        // Calculate the coordinates of the other four points on the pentagon
        for (i in 1..4) {
            val x = (centerX + radius * Math.cos(i * angle)).toFloat()
            val y = (centerY + radius * Math.sin(i * angle)).toFloat()
            path.lineTo(x, y) // Connect each point with a line
        }

        path.close() // Close the path to complete the pentagon

        return path
    }

    fun cutHexagon(bitmap: Bitmap): Bitmap {
        val hexagonWidth = bitmap.width / 2
        val hexagonHeight = bitmap.height / 2

        val output = Bitmap.createBitmap(hexagonWidth, hexagonHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val path = createHexagonPath(hexagonWidth, hexagonHeight)

        val paint = Paint()
        paint.isAntiAlias = true

        canvas.drawPath(path, paint)

        val paintXferMode = Paint()
        paintXferMode.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(bitmap, 0f, 0f, paintXferMode)

        return output
    }

    fun createHexagonPath(width: Int, height: Int): Path {
        val path = Path()

        val centerX = width / 2f
        val centerY = height / 2f

        val radius = Math.min(width, height) / 2f

        val angle = Math.PI * 2 / 6 // Angle between each point on the hexagon
        val startPointX = centerX + radius
        val startPointY = centerY

        path.moveTo(startPointX, startPointY) // Move to the starting point

        // Calculate the coordinates of the other five points on the hexagon
        for (i in 1..5) {
            val x = (centerX + radius * Math.cos(i * angle)).toFloat()
            val y = (centerY + radius * Math.sin(i * angle)).toFloat()
            path.lineTo(x, y) // Connect each point with a line
        }

        path.close() // Close the path to complete the hexagon

        return path
    }
}