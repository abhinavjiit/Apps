package com.bigstep.videoapp.di

import com.bigstep.videoapp.videoListing.VideoListingRepo
import com.bigstep.videoapp.videoListing.VideosListViewModelFact
import dagger.Module
import dagger.Provides


@Module
class VideosModule {

    @Provides
    fun providesVideosViewModelInstance(videoListingRepo: VideoListingRepo): VideosListViewModelFact {
        return VideosListViewModelFact(videoListingRepo)
    }
}