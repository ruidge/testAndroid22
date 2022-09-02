package com.example.testandroid22.scroll

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid22.utils.RLog


class TestRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {


    private var mVelocityTracker: VelocityTracker
    private val mMaxVelocity: Int

    private var mPointerId = 0

    init {
        mVelocityTracker = VelocityTracker.obtain()
        mMaxVelocity = ViewConfiguration.get(context).scaledMaximumFlingVelocity;
    }

    public var flingCallback: ((Float, Float) -> Unit)? = null

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action: Int = event.action

        mVelocityTracker.addMovement(event)

        val verTracker = mVelocityTracker
        when (action) {
            MotionEvent.ACTION_DOWN ->
                mPointerId = event.getPointerId(0)
            MotionEvent.ACTION_MOVE -> {
//                verTracker.computeCurrentVelocity(1000, mMaxVelocity.toFloat())
//                val velocityX = verTracker.getXVelocity(mPointerId)
//                val velocityY = verTracker.getYVelocity(mPointerId)
//                recodeVelocity(velocityX, velocityY)
            }
            MotionEvent.ACTION_UP -> {
                verTracker.computeCurrentVelocity(1000, mMaxVelocity.toFloat())
                val velocityX = verTracker.getXVelocity(mPointerId)
                val velocityY = verTracker.getYVelocity(mPointerId)
                recodeVelocity(velocityX, velocityY)
                clearVelocityTracker()
            }
            MotionEvent.ACTION_CANCEL -> clearVelocityTracker()
        }
        return super.onTouchEvent(event)
    }

    private fun recodeVelocity(velocityX: Float, velocityY: Float) {
        flingCallback?.invoke(velocityX, velocityY)
        RLog.rz_w("velocityX:$velocityX, velocityY:$velocityY")
    }

    private fun clearVelocityTracker() {
        mVelocityTracker.clear()
    }
}