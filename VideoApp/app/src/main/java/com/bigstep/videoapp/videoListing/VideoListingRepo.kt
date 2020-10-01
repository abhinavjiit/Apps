package com.bigstep.videoapp.videoListing

import com.bigstep.videoapp.Resource
import com.bigstep.videoapp.model.Result
import com.bigstep.videoapp.model.VideoListingResponse

interface VideoListingRepo {
    suspend fun getAllVideos(): Resource<VideoListingResponse>
    suspend fun updateDatabaseVideosList(videoEntity: Result)
    suspend fun getVideosFromDatabase(): List<Result>?
}