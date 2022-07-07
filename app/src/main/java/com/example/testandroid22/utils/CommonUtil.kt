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
}