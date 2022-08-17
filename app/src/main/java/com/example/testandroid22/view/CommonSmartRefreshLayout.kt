package com.example.testandroid22.view

import android.content.Context
import android.util.AttributeSet
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class CommonSmartRefreshLayout constructor(
    context: Context, attrs: AttributeSet? = null
) : SmartRefreshLayout(context, attrs) {

    init {
        setDragRate(1.0f)
        setEnableOverScrollBounce(false)
        setEnableOverScrollDrag(false)
    }
}
