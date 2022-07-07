package com.example.testandroid22.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid22.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }
}