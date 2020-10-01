package com.bigstep.videoapp.videoListing

import com.bigstep.videoapp.NetworkApiCall
import com.bigstep.videoapp.Resource
import com.bigstep.videoapp.ResponseHandler
import com.bigstep.videoapp.db.VideosDataBase
import com.bigstep.videoapp.model.Result
import com.bigstep.videoapp.model.VideoListingResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoListingRepoImpl(
    private val apiCall: NetworkApiCall,
    private val videosDataBase: VideosDataBase
) :
    VideoListingRepo {
    override suspend fun getAllVideos(): Resource<VideoListingResponse> {
        return try {
            ResponseHandler().handleSuccess(apiCall.getAllVideosList())
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }

    override suspend fun updateDatabaseVideosList(videoEntity: Result) {
        CoroutineScope(Dispatchers.IO).launch {
            videosDataBase.getVideosList().updateVideosDataBase(videoEntity)
        }
    }


    override suspend fun getVideosFromDatabase(): List<Result>? {
        return videosDataBase.getVideosList().getVideosFromDatabase()

    }
}