package com.bigstep.videoapp.di

import com.bigstep.videoapp.constructorInjection.Service
import dagger.Subcomponent

@Subcomponent
interface ServiceComponent {
    fun getService(): Service
}