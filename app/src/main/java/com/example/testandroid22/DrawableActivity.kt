package com.example.testandroid22

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class DrawableActivity : AppCompatActivity() {

    lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_drawable, null, false)
        setContentView(root)

        init()
    }

    private fun init() {
        val iv1: ImageView = findViewById(R.id.iv1)
        val iv2: ImageView = findViewById(R.id.iv2)
        val iv3: ImageView = findViewById(R.id.iv3)
        val bt1: Button = findViewById(R.id.bt1)
        val bt2: Button = findViewById(R.id.bt2)
        val iv4: ImageView = findViewById(R.id.iv4)
        val iv5: ImageView = findViewById(R.id.iv5)
        val view12: View = findViewById(R.id.view12)


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