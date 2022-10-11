package com.example.testandroid22

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.example.testandroid22.databinding.ActivityDrawableBinding
import com.example.testandroid22.utils.density.dp2px

class DrawableActivity : AppCompatActivity() {

    lateinit var binding: ActivityDrawableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDrawableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        with(binding) {


            val vectorDrawable1: VectorDrawableCompat? =
                VectorDrawableCompat.create(resources, R.drawable.btn_add_nor, theme)
            val vectorDrawable2: VectorDrawableCompat? =
                vectorDrawable1?.constantState?.newDrawable()?.mutate() as? VectorDrawableCompat
            val vectorDrawable3: VectorDrawableCompat? =
                vectorDrawable1?.constantState?.newDrawable()?.mutate() as? VectorDrawableCompat

            iv1.setImageDrawable(vectorDrawable1)
            vectorDrawable2?.let {
                it.setTint(resources.getColor(R.color.blue_violet))
                iv2.setImageDrawable(it)
            }

            vectorDrawable3?.let {
                it.setTint(resources.getColor(R.color.black))
                iv3.setImageDrawable(it)
            }


            val fromDrawable = ColorDrawable(Color.parseColor("#FFFF0000"))
            val toDrawable1 = ColorDrawable(Color.parseColor("#900000FF"))
            val toDrawable2 = ColorDrawable(Color.parseColor("#900000FF"))
            iv5.setImageDrawable(toDrawable2)

            val td1 = TransitionDrawable(
                arrayOf<Drawable>(
                    fromDrawable, toDrawable1
                )
            )
            iv4.setImageDrawable(td1)
            //设为false,第一张永远不透明,如果第二张有透明会透过去显示第一张,设为true,第一张会变为透明
            //td.isCrossFadeEnabled = false
            td1.isCrossFadeEnabled = true
            iv4.background = toDrawable1
            bt1.setOnClickListener {
                td1.startTransition(1000)
            }
            bt2.setOnClickListener {
                td1.reverseTransition(1000)
            }
            view12.background = genBottomGradient()

            val params = view3.layoutParams as RelativeLayout.LayoutParams
//            params.topMargin = (-30).dp2px
            params.topMargin = (-20).dp2px
            view3.layoutParams = params
        }
    }

    fun genBottomGradient(
    ): GradientDrawable {
//        val startColor = Color.parseColor("#00000000")
        val startColor = Color.parseColor("#00FFFFFF")
        var endColor: Int = Color.parseColor("#FFFFFFFF")
        val drawable = GradientDrawable().apply {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM
            shape = GradientDrawable.RECTANGLE
            gradientType = GradientDrawable.LINEAR_GRADIENT
            colors = intArrayOf(
                startColor, endColor
            )
        }

        return drawable
    }
}