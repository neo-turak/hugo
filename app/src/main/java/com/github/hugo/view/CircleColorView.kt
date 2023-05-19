package com.github.hugo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.github.hugo.R

class CircleColorView : View {

    val paint = Paint()

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

    private fun initView(context: Context?, attrs: AttributeSet?) {
        val ta = context!!.obtainStyledAttributes(attrs, R.styleable.CircleColorView)
        val c = ta.getColor(R.styleable.CircleColorView_shape_soldColor, Color.WHITE)
        ta.recycle()
        paint.color = c
    }

    fun setCircleColor(color: Int) {
        paint.color = color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.isAntiAlias = true
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val size = width.coerceAtMost(height)
        setMeasuredDimension(size, size)
    }
}
