package com.example.testandroid22

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid22.databinding.ActivityOutlineBinding
import com.example.testandroid22.utils.CommonUtil
import com.example.testandroid22.utils.density.dp2pxF

class OutlineActivity : AppCompatActivity() {

    lateinit var binding: ActivityOutlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutlineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(this)
    }

    private fun init(context: Context) {
        with(binding) {
            CommonUtil.clipViewOutline(rlContainer, 20.dp2pxF)
            CommonUtil.clipViewOutline(root, 50.dp2pxF)
            CommonUtil.clipViewOutline(iv1, 50.dp2pxF)
            CommonUtil.clipViewOutlineBottomRadius(iv2, 50.dp2pxF)
        }

    }
}