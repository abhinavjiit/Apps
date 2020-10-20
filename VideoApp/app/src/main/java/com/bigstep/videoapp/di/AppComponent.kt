package com.bigstep.videoapp.di

import com.bigstep.videoapp.videoListing.AllVideoListingFragment
import com.bigstep.videoapp.videoListing.PreviouslySelectedVideosFragment
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [ RoomDataBaseModule::class, RetrofitModule::class])
interface AppComponent {
    fun getServiceComponent(): ServiceComponent
    fun getActivityComponent(): ActivityComponent.Factory
}