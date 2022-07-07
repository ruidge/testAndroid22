package com.example.testandroid22

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid22.utils.CommonUtil
import com.example.testandroid22.utils.density.dp2pxF

class OutlineActivity : AppCompatActivity() {

    lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = layoutInflater.inflate(R.layout.activity_outline, null, false)
        setContentView(root)

        init()
    }

    private fun init() {
        val container: View = findViewById(R.id.rl_container)
        val iv1: ImageView = findViewById(R.id.iv1)

        CommonUtil.clipViewOutline(container, 20.dp2pxF)
        CommonUtil.clipViewOutline(root, 50.dp2pxF)
        CommonUtil.clipViewOutline(iv1, 50.dp2pxF)
    }
}