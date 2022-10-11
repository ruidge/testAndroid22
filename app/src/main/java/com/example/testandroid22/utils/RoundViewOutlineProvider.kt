package com.example.testandroid22.utils

import android.graphics.Outline
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.view.View
import android.view.ViewOutlineProvider

class RoundViewOutlineProvider(private val radius: Float) : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        val selfRect = Rect(0, 0, view.width, view.height)
        outline.setRoundRect(selfRect, radius)
    }
}

class BottomRoundViewOutlineProvider(private val radius: Float) : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        val path = Path()
        path.addRoundRect(
            RectF(0f, 0f, view.width.toFloat(), view.height.toFloat()),
            floatArrayOf(
                0f,
                0f,
                0f,
                0f,
                radius.toFloat(),
                radius.toFloat(),
                radius.toFloat(),
                radius.toFloat()
            ),
            Path.Direction.CW
        )
        path.close()
        outline.setConvexPath(path)

    }
}
