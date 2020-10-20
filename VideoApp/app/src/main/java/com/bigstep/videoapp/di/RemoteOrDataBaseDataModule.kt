package com.bigstep.videoapp.di

import com.bigstep.videoapp.NetworkApiCall
import com.bigstep.videoapp.db.VideosDataBase
import com.bigstep.videoapp.videoListing.VideoListingRepo
import com.bigstep.videoapp.videoListing.VideoListingRepoImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteOrDataBaseDataModule {

    @Provides
    fun providesRemoteOrDataBaseDataInstance(
        apiCall: NetworkApiCall,
        videosDataBase: VideosDataBase
    ): VideoListingRepo {
        return VideoListingRepoImpl(apiCall = apiCall, videosDataBase = videosDataBase)
    }
}