package com.example.testandroid22

import android.app.Application
import android.content.Context

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        _context = applicationContext
    }

    companion object {
        private lateinit var _context: Context
        val context: Context
            get() = _context
    }

}