package com.example.testandroid22.utils

import android.widget.Toast
import com.example.testandroid22.App

object RToast {

    fun toast(msg: String?) {
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show()
    }
}