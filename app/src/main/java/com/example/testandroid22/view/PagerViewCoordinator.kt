package com.example.testandroid22.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid22.R

class PagerViewCoordinator constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val refreshLayout: CommonSmartRefreshLayout
    val recyclerview: RecyclerView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_page_coordinator, this, true)
        refreshLayout = findViewById(R.id.refreshLayout)
        recyclerview = findViewById(R.id.recyclerview)

        val header = SimpleRefreshHeader(context)
        refreshLayout.setRefreshHeader(header)

        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = IntViewAdapter(context)
    }

    fun setData(color: Int) {
        setBackgroundColor(
            color
        )
    }
}