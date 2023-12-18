package com.example.shemajamebeli5

import android.app.Application

class App : Application() {

    companion object {
        lateinit var application: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()

        application = this
    }
}