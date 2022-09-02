package com.example.testandroid22

import android.os.Bundle
import android.view.View
import android.widget.OverScroller
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid22.scroll.TestRecyclerView
import com.example.testandroid22.utils.RLog
import com.example.testandroid22.utils.density.dp2px
import com.example.testandroid22.view.IntViewAdapter

class ScrollActivity : AppCompatActivity() {

    lateinit var root: View
    lateinit var recyclerview1: TestRecyclerView
    lateinit var recyclerview2: RecyclerView
    lateinit var bt_scroll: View
    lateinit var bt_fling: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_scroll, null, false)
        setContentView(root)
        recyclerview1 = findViewById(R.id.recyclerview1)
        recyclerview2 = findViewById(R.id.recyclerview2)
        bt_scroll = findViewById(R.id.bt_scroll)
        bt_fling = findViewById(R.id.bt_fling)

        init()
    }

    private fun init() {

        recyclerview1.layoutManager = LinearLayoutManager(this)
        recyclerview1.adapter = IntViewAdapter(this)

        recyclerview2.layoutManager = LinearLayoutManager(this)
        recyclerview2.adapter = IntViewAdapter(this)

        recyclerview1.flingCallback = { velocityX: Float, velocityY: Float ->
            recyclerview2.fling(0 - velocityY.toInt(), 0 - velocityY.toInt())
        }

        bt_scroll.setOnClickListener(::testScroll)
        bt_fling.setOnClickListener(::testFling)
    }

    fun testScroll(v: View) {
        var init: Int = 0
        val scrollRunnable = ScrollRunnable(v) {
            RLog.rz_w("scroll $it")
            recyclerview2.scrollBy(0, it - init)
            init = it
        }
        scrollRunnable.startScroll(400.dp2px, 2000)
    }

    fun testFling(v: View) {
        var init: Int = 0
        val scrollRunnable = ScrollRunnable(v) {
            RLog.rz_w("fling $it")
            recyclerview2.scrollBy(0, it - init)
            init = it
        }
//        scrollRunnable.startFling(6000, 400.dp2px, true, 100.dp2px)
        scrollRunnable.startFling(6000, 400.dp2px, false, 50.dp2px)
    }


    class ScrollRunnable(val view: View, val scrollCallback: (Int) -> Unit) : Runnable {
        val scroller: OverScroller = OverScroller(view.context)

        var dy: Int = 0

        fun startScroll(dy: Int, duration: Int) {
            this.dy = dy
            //dx>0,向右滚,即内容向左,dy>0,向下滚,即内容向上
            scroller.startScroll(0, 0, 0, dy, duration)
            view.post(this)
        }

        fun startFling(velocityY: Int, dy: Int, isDown: Boolean, overY: Int) {
            this.dy = dy
            //minX <= 终止值的x坐标 <= maxX, minY <= 终止值的y坐标 <= maxY 需判断正负
            //overY
            scroller.fling(
                0,
                0,
                0,
                if (isDown) {
                    velocityY
                } else {
                    -velocityY
                },
                0,
                0,
                if (isDown) {
                    0
                } else {
                    -dy
                },
                if (isDown) {
                    dy
                } else {
                    0
                },
                0,
                overY,
            )
            view.post(this)
        }

        override fun run() {
            if (scroller.computeScrollOffset()) {
                val y = scroller.currY
                scrollCallback.invoke(y)
                ViewCompat.postOnAnimation(view, this)
            } else {
                scrollCallback.invoke(scroller.finalY)
            }
        }
    }
}