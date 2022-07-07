package com.example.testandroid22.utils

import android.graphics.Outline
import android.graphics.Rect
import android.view.View
import android.view.ViewOutlineProvider

class RoundViewOutlineProvider(private val radius: Float) : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        val selfRect = Rect(0, 0, view.width, view.height)
        outline.setRoundRect(selfRect, radius)
    }
}
