package com.bigstep.videoapp

import android.app.Application
import android.content.Context
import com.bigstep.videoapp.di.AppComponent
import com.bigstep.videoapp.di.DaggerAppComponent
import com.bigstep.videoapp.di.RoomDataBaseModule

class BaseApplication : Application(), Injector {

    private lateinit var context: Context
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        setInstance(this)
        appComponent =
            DaggerAppComponent.builder().roomDataBaseModule(RoomDataBaseModule(this)).build()

    }

    override fun createVideosComponent(): AppComponent {
        return appComponent
    }

    private fun setInstance(context: Context) {
        this.context = context
    }

    fun getInstance(): Context {
        return context
    }

}