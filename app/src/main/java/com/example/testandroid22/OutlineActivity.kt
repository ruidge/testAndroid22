package com.example.testandroid22.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testandroid22.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }
}