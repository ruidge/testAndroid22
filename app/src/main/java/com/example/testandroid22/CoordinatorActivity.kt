package com.example.testandroid22

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid22.utils.density.dp2px
import com.example.testandroid22.utils.density.dp2pxF
import com.example.testandroid22.view.CommonSmartRefreshLayout
import com.example.testandroid22.view.SimpleRefreshHeader
import com.example.testandroid22.view.recyclerview.ItemViewHolder
import com.google.android.material.appbar.AppBarLayout

class CoordinatorActivity : AppCompatActivity() {

    lateinit var root: View
    lateinit var appBarLayout: AppBarLayout
    lateinit var refreshLayout: CommonSmartRefreshLayout
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_coordinator, null, false)
        setContentView(root)
        appBarLayout = findViewById(R.id.appBarLayout)
        refreshLayout = findViewById(R.id.refreshLayout)
        recyclerview = findViewById(R.id.recyclerview)

        init()
    }

    private fun init() {
        val header = SimpleRefreshHeader(this)
        refreshLayout.setRefreshHeader(header)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = RecSceneAdapter(this)
    }


    class RecSceneAdapter(
        private val context: Context,
    ) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private val recSceneList: MutableList<Int> = mutableListOf()

        init {
            for (index in 1..100) {
                this.recSceneList.add(index)
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
            val index = recSceneList[position]
            val itemView = holder.itemView
            (itemView as? TextView)?.apply {
                text = "$index"
                setBackgroundColor(
                    if (position % 2 == 0) {
                        context.resources.getColor(R.color.white)
                    } else {
                        context.resources.getColor(R.color.gray)
                    }
                )
            }
        }

        override fun getItemCount(): Int {
            return recSceneList.size
        }
    }

}