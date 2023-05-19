package com.github.hugo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.github.hugo.R
import com.github.neoturak.common.dp2px


/**
 * @author 努尔江
 * Created on: 2023/3/17
 * @project AI Astrology
 * Description: it has the gradient color progress bar with rounded.
 *
 * Using： android:progress="63"              the progress of the View.
android:background="#363636"       (默认) the bg color for drawing.
app:gradient_startColor="#A689C3"  (默认) progress start color
app:gradient_endColor="#A689C3"    (默认) progress end color.
 **/

class OverallProgressView : View {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mProgress: Int = 0
    private var bgColor: Int = 0
    private var drawWidth = 0f
    private var startColor: Int = 0
    private var endColor: Int = 0

    constructor(context: Context?) : super(context) {
        initView(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    init {
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.style = Paint.Style.FILL
    }

    //if want to see the real effect, just open the below code.
   override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (isInEditMode) {
            setMeasuredDimension(context.dp2px(100), context.dp2px(10))
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    private fun initView(context: Context?, attrs: AttributeSet?) {
        val ta = context!!.obtainStyledAttributes(attrs, R.styleable.OverallProgressView)
        mProgress = ta.getInteger(R.styleable.OverallProgressView_android_progress, 68)
        bgColor = ta.getColor(
            R.styleable.OverallProgressView_android_background,
            Color.parseColor("#363636")
        )
        startColor = ta.getInteger(
            R.styleable.OverallProgressView_gradient_startColor,
            Color.parseColor("#FB9E54")
        )
        endColor = ta.getColor(
            R.styleable.OverallProgressView_gradient_endColor,
            Color.parseColor("#ED7EE1")
        )
        ta.recycle()
    }

    fun setProgress(progress: Int) {
        this.mProgress = progress
        invalidate()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mProgress == 0) {
            return
        }
        drawWidth = (width - height / 2) * (mProgress / 100f)
        mPaint.strokeWidth = height.toFloat()
        if (isInEditMode) {
            //  canvas?.drawColor(Color.WHITE)
        }
        val progressGradient = LinearGradient(
            drawWidth,
            height.toFloat(),
            0f,
            0f,
            startColor,
            endColor,
            Shader.TileMode.CLAMP
        )
        mPaint.color = bgColor
        mPaint.shader = null
        canvas!!.drawLine(
            0f + height / 2,
            height / 2f,
            width.toFloat() - height / 2,
            height / 2f,
            mPaint
        )
        if (startColor == endColor) {
            mPaint.color = startColor
        } else {
            mPaint.shader = progressGradient
            mPaint.color = Color.CYAN
        }
        canvas.drawLine(
            0f + height / 2,
            height / 2f,
            drawWidth,
            height / 2f,
            mPaint
        )
    }
}