package com.example.testandroid22.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.testandroid22.R
import com.example.testandroid22.utils.RLog

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)


        RLog.rz_i("activity onCreate")
    }

    override fun onStart() {
        super.onStart()
        RLog.rz_i("activity onStart")
    }

    override fun onResume() {
        super.onResume()
        RLog.rz_i("activity onResume")
    }

    override fun onPause() {
        super.onPause()
//        lifecycle.addObserver(TestObserver2())
        RLog.rz_i("activity onPause")
    }

    override fun onStop() {
        super.onStop()
        lifecycle.addObserver(TestObserver2())
        RLog.rz_i("activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        RLog.rz_i("activity onDestroy")
    }
}

/**
 * 直接实现接口
 */
class TestObserver1 : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        RLog.rz_i("observer create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        RLog.rz_i("observer start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        RLog.rz_i("observer resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        RLog.rz_i("observer pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        RLog.rz_i("observer stop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        RLog.rz_i("observer destroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun doAny() {
        RLog.rz_i("observer doAny")
    }

}

class TestObserver2 : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        RLog.rz_i("observer onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        RLog.rz_i("observer onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        RLog.rz_i("observer onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        RLog.rz_i("observer onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        RLog.rz_i("observer onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        RLog.rz_i("observer onDestroy")

    }
}
