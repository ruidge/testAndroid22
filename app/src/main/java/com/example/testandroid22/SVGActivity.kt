package com.example.testandroid22

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class SVGActivity : AppCompatActivity() {

    lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_svg, null, false)
        setContentView(root)

        init()
    }

    private fun init() {
        val iv1: ImageView = findViewById(R.id.iv1)
        val iv2: ImageView = findViewById(R.id.iv2)


        val vectorDrawable1: VectorDrawableCompat? =
            VectorDrawableCompat.create(resources, R.drawable.btn_add_nor, theme)
        iv1.setImageDrawable(vectorDrawable1)
        val vectorDrawable2: VectorDrawableCompat? =
            VectorDrawableCompat.create(resources, R.drawable.btn_add_nor, theme)
        vectorDrawable2?.let {
            it.setTint(resources.getColor(R.color.blue_violet))
            iv2.setImageDrawable(it)
        }
    }
}