package com.example.testandroid22.utils

import android.util.Log

object RLog {

    private const val TAG = "rui.zhang"

    fun w(tag: String, msg: String?) {
        Log.w(TAG, "$tag : ${msg ?: "null"}")
    }

    fun e(tag: String, msg: String?) {
        Log.e(TAG, "$tag : ${msg ?: "null"}")
    }

    fun rz_i(msg: String?) {
        Log.i(TAG, msg ?: "null")
    }

    fun rz_w(msg: String?) {
        Log.w(TAG, msg ?: "null")
    }

    fun rz_e(msg: String?) {
        Log.e(TAG, msg ?: "null")
    }
}