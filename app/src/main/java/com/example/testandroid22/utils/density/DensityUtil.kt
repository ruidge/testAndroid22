package com.example.testandroid22.utils.density

import android.content.Context
import android.content.res.Resources
import android.util.Log

object DensityUtil {
    private val TAG = DensityUtil::class.java.simpleName
    private const val ERROR_MESSAGE = "请检查context是否为空"

    /**
     * dp转px
     */
    fun dp2px(dpValue: Float): Float {
        val density = Resources.getSystem().displayMetrics.density
        return 0.5F + dpValue * density
    }

    /**
     * px转dp
     */
    fun px2dp(pxValue: Float): Float {
        val density = Resources.getSystem().displayMetrics.density
        return pxValue / density
    }

    /**
     * 获取屏幕密度
     */
    fun getDensity(context: Context?): Float {
        context?.let {
            return it.resources.displayMetrics.density
        }
        Log.e(TAG, ERROR_MESSAGE)
        return 0F
    }

    /**
     * 获取屏幕密度的dpi
     */
    fun getDensityDpi(context: Context?): Int {
        context?.let {
            return it.resources.displayMetrics.densityDpi
        }
        Log.e(TAG, ERROR_MESSAGE)
        return 0
    }

}