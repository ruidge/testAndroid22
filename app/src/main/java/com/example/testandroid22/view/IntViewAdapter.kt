package com.example.testandroid22.view

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid22.utils.density.dp2px
import com.example.testandroid22.utils.density.dp2pxF
import com.example.testandroid22.view.recyclerview.ItemViewHolder

class IntViewAdapter(
    private val context: Context,
    private val endInt: Int = 100
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val intList: MutableList<Int> = mutableListOf()

    init {
        for (index in 1..endInt) {
            this.intList.add(index)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        var textView = TextView(context)
        textView.layoutParams =
            RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                80.dp2px
            )
        textView.textSize = 12.dp2pxF
        textView.gravity = Gravity.CENTER
        textView.setTextColor(Color.BLACK)
        return ItemViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val index = intList[position]
        val itemView = holder.itemView
        (itemView as? TextView)?.apply {
            text = "$index"
        }
    }

    override fun getItemCount(): Int {
        return intList.size
    }
}