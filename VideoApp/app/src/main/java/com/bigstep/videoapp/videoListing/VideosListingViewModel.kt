package com.bigstep.videoapp.videoListing

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bigstep.videoapp.Resource
import com.bigstep.videoapp.model.Result
import com.bigstep.videoapp.model.VideoListingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VideosListingViewModel(private val videoListingRepo: VideoListingRepo) : ViewModel() {
    var netWorkStates = MutableLiveData<Resource.Status>()
    var data = MutableLiveData<Resource<VideoListingResponse>>()

    fun getVideosList() = liveData(Dispatchers.IO) {
        Log.d("Dispacther", Thread.currentThread().name)
        if (netWorkStates.value == Resource.Status.LOADING || netWorkStates.value == Resource.Status.SUCCESS
        ) {
            emit(data.value)
        } else {
            val res = videoListingRepo.getAllVideos()
            data.postValue(res)
            netWorkStates.postValue(Resource.Status.LOADING)
            emit(data.value)
        }
    }

    fun getDataBaseVideos() = liveData {
        Log.d("Dispacther", Thread.currentThread().name)
        val databaseVideos = videoListingRepo.getVideosFromDatabase()
        emit(databaseVideos)
    }

    fun updateDataBaseVideos(selectedVideo: Result) =
        GlobalScope.launch {
            videoListingRepo.updateDatabaseVideosList(videoEntity = selectedVideo)
        }


}