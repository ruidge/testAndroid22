package com.example.testandroid22.utils

import android.view.View

object CommonUtil {

    public fun clipViewOutline(
        view: View,
        radius: Float
    ): Unit {
        view.outlineProvider = RoundViewOutlineProvider(radius)
        view.clipToOutline = true
    }

    public fun clipViewOutlineBottomRadius(
        view: View,
        radius: Float
    ): Unit {
        view.outlineProvider = BottomRoundViewOutlineProvider(radius)
        view.clipToOutline = true
    }
}