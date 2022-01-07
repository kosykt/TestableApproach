package com.example.testableapproach.presentation

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object{
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}