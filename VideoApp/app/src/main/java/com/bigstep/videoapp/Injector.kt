package com.bigstep.videoapp

import com.bigstep.videoapp.di.AppComponent

interface Injector {

    fun createVideosComponent(): AppComponent
}