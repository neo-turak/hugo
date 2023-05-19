package com.github.hugo.ui.decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.github.hugo.application
import com.github.neoturak.common.dp2px
import com.github.neoturak.common.sp2px
import javax.inject.Inject

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

class ImageItemDecoration
@Inject
constructor() : ItemDecoration() {
    private val painter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = application.dp2px(0.5f)
        textAlign = Paint.Align.CENTER
        textSize = application.sp2px(6f)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val ctx = parent.context
        val child = parent.getChildAdapterPosition(view)
        val isLeft = child % 2 == 0
        if (isLeft) {
            outRect.set(ctx.dp2px(10), ctx.dp2px(10), ctx.dp2px(5), 0)
        } else {
            outRect.set(ctx.dp2px(5), ctx.dp2px(10), ctx.dp2px(10), 0)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position % 2 == 0) {

                painter.style = Paint.Style.FILL_AND_STROKE
                painter.color = Color.RED
                c.drawCircle(
                    child.right.toFloat()+ application.dp2px(5),
                    child.bottom.toFloat() + application.dp2px(5),
                    application.dp2px(5f),
                    painter
                )
                painter.style = Paint.Style.STROKE
                painter.color = Color.WHITE
                c.drawText((position/2).plus(1).toString(),
                    child.right.toFloat()+ application.dp2px(5),
                    child.bottom.toFloat() + application.dp2px(7),
                    painter
                    )
            }
        }
    }

}