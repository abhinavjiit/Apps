package com.bigstep.videoapp.videoListing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bigstep.videoapp.model.Result
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VideosListingViewModel(private val videoListingRepo: VideoListingRepo) : ViewModel() {


    fun getVideosList() = liveData {
        val response = videoListingRepo.getAllVideos()
        emit(response)
    }

    fun getDataBaseVideos() = liveData {
        val databaseVideos = videoListingRepo.getVideosFromDatabase()
        emit(databaseVideos)
    }

    fun updateDataBaseVideos(selectedVideo: Result) =
        GlobalScope.launch {
            videoListingRepo.updateDatabaseVideosList(videoEntity = selectedVideo)
        }


}