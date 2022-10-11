package com.example.testandroid22

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid22.databinding.ActivityMainBinding
import com.example.testandroid22.lifecycle.LifecycleActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(this)
    }

    private fun init(context: Context) {
        with(binding) {
            btLifecycle.setOnClickListener {
                startActivity(Intent(context, LifecycleActivity::class.java))
            }
            btOutline.setOnClickListener {
                startActivity(Intent(context, OutlineActivity::class.java))
            }
            btDrawable.setOnClickListener {
                startActivity(Intent(context, DrawableActivity::class.java))
            }
            btCoordinator.setOnClickListener {
                startActivity(Intent(context, CoordinatorActivity::class.java))
            }
            btScroll.setOnClickListener {
                startActivity(Intent(context, ScrollActivity::class.java))
            }
        }
    }
}