package com.example.testandroid22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid22.lifecycle.LifecycleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        findViewById<Button>(R.id.bt_lifecycle).setOnClickListener {
            startActivity(Intent(this, LifecycleActivity::class.java))
        }
        findViewById<Button>(R.id.bt_outline).setOnClickListener {
            startActivity(Intent(this, OutlineActivity::class.java))
        }
    }
}