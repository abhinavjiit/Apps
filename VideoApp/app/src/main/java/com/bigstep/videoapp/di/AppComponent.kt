package com.bigstep.videoapp.di

import com.bigstep.videoapp.videoListing.AllVideoListingFragment
import com.bigstep.videoapp.videoListing.PreviouslySelectedVideosFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [VideosModule::class, RoomDataBaseModule::class, RetrofitModule::class, RemoteOrDataBaseDataModule::class])
interface AppComponent {
    fun inject(allVideoListingFragment: AllVideoListingFragment)
    fun inject(previouslySelectedVideosFragment: PreviouslySelectedVideosFragment)
}