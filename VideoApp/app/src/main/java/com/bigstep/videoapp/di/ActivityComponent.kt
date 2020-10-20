package com.bigstep.videoapp.di

import com.bigstep.videoapp.videoListing.AllVideoListingFragment
import com.bigstep.videoapp.videoListing.PreviouslySelectedVideosFragment
import dagger.Component
import dagger.Subcomponent


@Subcomponent(modules = [VideosModule::class, RemoteOrDataBaseDataModule::class])
interface ActivityComponent {
    fun inject(allVideoListingFragment: AllVideoListingFragment)
    fun inject(previouslySelectedVideosFragment: PreviouslySelectedVideosFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }
}