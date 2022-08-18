package com.example.testandroid22

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.testandroid22.utils.RLog
import com.example.testandroid22.view.PagerViewCoordinator
import com.google.android.material.appbar.AppBarLayout

class CoordinatorActivity : AppCompatActivity() {

    lateinit var root: View
    lateinit var appBarLayout: AppBarLayout
    lateinit var viewpager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_coordinator, null, false)
        setContentView(root)
        appBarLayout = findViewById(R.id.appBarLayout)
        viewpager = findViewById(R.id.viewpager)

        init()
    }

    private fun init() {
        viewpager.adapter = TestAdapter(this)
        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            RLog.rz_w("onOffsetChanged: $verticalOffset")
        }

        findViewById<View>(R.id.bt1).setOnClickListener {
            appBarLayout.setExpanded(true)
        }

        findViewById<View>(R.id.bt2).setOnClickListener {
            appBarLayout.setExpanded(false)
        }

    }

    class TestAdapter(
        private val context: Context,
    ) :
        PagerAdapter() {
        val viewList: MutableList<PagerViewCoordinator> = mutableListOf()

        init {
            viewList.run {
                add(PagerViewCoordinator(context))
                add(PagerViewCoordinator(context))
                add(PagerViewCoordinator(context))
            }
        }

        override fun getCount(): Int {
            return viewList.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = viewList[position]

            view.setData(
                if (position % 3 == 0) {
                    context.resources.getColor(R.color.white)
                } else if (position % 3 == 1) {
                    context.resources.getColor(R.color.gray)
                } else {
                    context.resources.getColor(R.color.orange)
                }
            )
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(viewList[position])
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }


    }
}