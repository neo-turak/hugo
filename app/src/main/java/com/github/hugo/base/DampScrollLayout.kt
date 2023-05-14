package com.github.hugo.base

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.TranslateAnimation
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DampScrollLayout
@JvmOverloads
constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var childView: RecyclerView? = null
    private val original = Rect()
    private var isMoved = false
    private var startYpos = 0f
    private var isSuccess = false
    private var mScrollListener: ScrollListener? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        childView = getChildAt(0) as RecyclerView
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        original[childView!!.left, childView!!.top, childView!!.right] = childView!!.bottom
    }

    fun setScrollListener(listener: ScrollListener?) {
        mScrollListener = listener
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val touchYpos = ev.y
        if (touchYpos >= original.bottom || touchYpos <= original.top) {
            if (isMoved) {
                recoverLayout()
            }
            return true
        }
        return when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                startYpos = ev.y
                val scrollYpos = (ev.y - startYpos).toInt()
                val pullDown = scrollYpos > 0 && canPullDown()
                val pullUp = scrollYpos < 0 && canPullUp()
                if (pullDown || pullUp) {
                    cancelChild(ev)
                    val offset = (scrollYpos * DAMPING_COEFFICIENT).toInt()
                    childView!!.layout(
                        original.left,
                        original.top + offset,
                        original.right,
                        original.bottom + offset
                    )
                    if (mScrollListener != null) {
                        mScrollListener!!.onScroll()
                    }
                    isMoved = true
                    isSuccess = false
                    true
                } else {
                    startYpos = ev.y
                    isMoved = false
                    isSuccess = true
                    super.dispatchTouchEvent(ev)
                }
            }

            MotionEvent.ACTION_MOVE -> {
                val scrollYpos = (ev.y - startYpos).toInt()
                val pullDown = scrollYpos > 0 && canPullDown()
                val pullUp = scrollYpos < 0 && canPullUp()
                if (pullDown || pullUp) {
                    cancelChild(ev)
                    val offset = (scrollYpos * DAMPING_COEFFICIENT).toInt()
                    childView!!.layout(
                        original.left,
                        original.top + offset,
                        original.right,
                        original.bottom + offset
                    )
                    if (mScrollListener != null) {
                        mScrollListener!!.onScroll()
                    }
                    isMoved = true
                    isSuccess = false
                    true
                } else {
                    startYpos = ev.y
                    isMoved = false
                    isSuccess = true
                    super.dispatchTouchEvent(ev)
                }
            }

            MotionEvent.ACTION_UP -> {
                if (isMoved) {
                    recoverLayout()
                }
                !isSuccess || super.dispatchTouchEvent(ev)
            }

            else -> true
        }
    }

    /**
     * 取消子view已经处理的事件
     *
     * @param ev event
     */
    private fun cancelChild(ev: MotionEvent) {
        ev.action = MotionEvent.ACTION_CANCEL
        super.dispatchTouchEvent(ev)
    }

    /**
     * 位置还原
     */
    private fun recoverLayout() {
        val anim = TranslateAnimation(0f, 0f, (childView!!.top - original.top).toFloat(), 0f)
        anim.duration = ANIM_TIME.toLong()
        childView!!.startAnimation(anim)
        childView!!.layout(original.left, original.top, original.right, original.bottom)
        isMoved = false
    }

    /**
     * 判断是否可以下拉
     *
     * @return true：可以，false:不可以
     */
    private fun canPullDown(): Boolean {
        val firstVisiblePosition =
            (childView!!.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
        if (firstVisiblePosition != 0 && childView!!.adapter!!.itemCount != 0) {
            return false
        }
        val mostTop = if (childView!!.childCount > 0) childView!!.getChildAt(0).top else 0
        return mostTop >= 0
    }

    /**
     * 判断是否可以上拉
     *
     * @return true：可以，false:不可以
     */
    private fun canPullUp(): Boolean {
        val lastItemPosition = childView!!.adapter!!.itemCount - 1
        val lastVisiblePosition =
            (childView!!.layoutManager as LinearLayoutManager?)!!.findLastVisibleItemPosition()
        if (lastVisiblePosition >= lastItemPosition) {
            val childIndex =
                lastVisiblePosition - (childView!!.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
            val childCount = childView!!.childCount
            val index = Math.min(childIndex, childCount - 1)
            val lastVisibleChild = childView!!.getChildAt(index)
            if (lastVisibleChild != null) {
                return lastVisibleChild.bottom <= childView!!.bottom - childView!!.top
            }
        }
        return false
    }

    interface ScrollListener {
        /**
         * 滚动事件回调
         */
        fun onScroll()
    }

    companion object {
        private const val ANIM_TIME = 400

        /**
         * 阻尼系数
         */
        private const val DAMPING_COEFFICIENT = 0.3f
    }
}